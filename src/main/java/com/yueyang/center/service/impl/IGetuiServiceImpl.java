package com.yueyang.center.service.impl;

import com.alibaba.fastjson.JSON;
import com.gexin.rp.sdk.base.IPushResult;

import com.gexin.rp.sdk.base.impl.*;
import com.gexin.rp.sdk.base.payload.APNPayload;
import com.gexin.rp.sdk.base.uitls.AppConditions;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.yueyang.center.domain.model.ResultModel;
import com.yueyang.center.domain.model.request.getui.*;
import com.yueyang.center.domain.properties.GtPushProperties;
import com.yueyang.center.enums.ErrorCode;
import com.yueyang.center.service.IGetuiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * @program: center
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-01 15:08
 **/
@Service
@Slf4j
public class IGetuiServiceImpl implements IGetuiService {

    @Autowired
    private GtPushProperties gtPushProperties;

    private IGtPush gtPush;

    public IGetuiServiceImpl(GtPushProperties gtPushProperties) {
        this.gtPushProperties = gtPushProperties;
        gtPush = new IGtPush(gtPushProperties.getHost(), gtPushProperties.getAppKey(), gtPushProperties.getMasterSecret());
    }

    /**
     * 单推
     *
     * @param param
     * @return
     */
    @Override
    public ResultModel<String> toSingle(ToSingleParam param) {
        SingleMessage message = getPushMessage(param, SingleMessage.class);
        if (message == null) {
            return ResultModel.fail();
        }

        Target target = new Target();
        target.setAppId(gtPushProperties.getAppId());
        target.setClientId(param.getClientId());

        IPushResult ret;
        try {
            ret = gtPush.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = gtPush.pushMessageToSingle(message, target, e.getRequestId());
        }

        return getChannelResult(ret);
    }

    /**
     * 批量推
     *
     * @param param
     * @return
     */
    @Override
    public ResultModel<String> toList(ToListParam param) {
        ListMessage message = getPushMessage(param, ListMessage.class);
        if (message == null) {
            return getChannelResult(null);
        }

        List<Target> targets = Lists.newArrayList();
        for (String clientId : param.getClientIds()) {
            Target target = new Target();
            target.setAppId(gtPushProperties.getAppId());
            target.setClientId(clientId);
            targets.add(target);
        }

        String taskId = gtPush.getContentId(message);
        IPushResult ret = gtPush.pushMessageToList(taskId, targets);
        return getChannelResult(ret);
    }

    /**
     * 群推
     *
     * @param param
     * @return
     */
    @Override
    public ResultModel<String> toAll(ToAllParam param) {
        AppMessage message = getPushMessage(param, AppMessage.class);
        if (message == null) {
            return getChannelResult(null);
        }

        AppConditions cdt = new AppConditions();
        if (!CollectionUtils.isEmpty(param.getDevices())) {
            List<String> phoneTypeList = Lists.newArrayList();
            for (PushDeviceEnum deviceEnum : param.getDevices()) {
                phoneTypeList.add(deviceEnum.getValue());
            }
            cdt.addCondition(AppConditions.PHONE_TYPE, phoneTypeList);
        }
        message.setConditions(cdt);

        List<String> appIdList = Lists.newArrayList();
        appIdList.add(gtPushProperties.getAppId());
        message.setAppIdList(appIdList);

        IPushResult ret = gtPush.pushMessageToApp(message);
        return getChannelResult(ret);
    }

    /**
     * 获取推送message
     *
     * @param param 参数
     * @param clazz 具体message的类型
     * @return
     */
    private <T extends Message> T getPushMessage(BaseParam param, Class<T> clazz) {
        try {
            TransmissionTemplate template = getTransmissionTemplate(param);

            T message = clazz.newInstance();
            message.setData(template);
            message.setOffline(true);
            message.setOfflineExpireTime(gtPushProperties.getOfflineExpireTime());

            return message;
        } catch (Exception e) {
            log.error("创建个推message失败", e);
            return null;
        }
    }

    /**
     * 获取透传模板
     *
     * @param param 参数
     * @return
     */
    private TransmissionTemplate getTransmissionTemplate(BaseParam param) {
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(gtPushProperties.getAppId());
        template.setAppkey(gtPushProperties.getAppKey());

        // 透传内容
        Map<String, Object> content = param.getExtras();
        if (content == null) {
            content = Maps.newHashMap();
        }
        if (!StringUtils.isEmpty(param.getTitle())) {
            content.put(PushConstants.EXTRA_CONTENT_TITLE, param.getTitle());
        }
        content.put(PushConstants.EXTRA_CONTENT_ALERT, param.getAlert());
        String jsonString = JSON.toJSONString(content);
        template.setTransmissionContent(jsonString);
        //transmissionType可选值为1、2，默认为2
        //1：立即启动APP（不推荐使用，影响客户体验）
        //2：客户端收到消息后需要自行处理
        template.setTransmissionType(PushConstants.GETUI_TRANSMISSION_TYPE);

        // IOS apn参数设置
        APNPayload payload = new APNPayload();
        payload.setAutoBadge(gtPushProperties.getBadge());
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        if (currentHour >= 0 && currentHour <= 6) {
            payload.setSound(APNPayload.APN_SOUND_SILENCE);
        }
        payload.addCustomMsg(PushConstants.GETUI_PAYLOAD, jsonString);

        APNPayload.DictionaryAlertMsg alertMsg = new APNPayload.DictionaryAlertMsg();
        if (!StringUtils.isEmpty(param.getTitle())) {
            alertMsg.setTitle(param.getTitle());
        }
        alertMsg.setBody(param.getAlert());
        payload.setAlertMsg(alertMsg);
        template.setAPNInfo(payload);

        return template;
    }

    /**
     * 将个推返回结果转换为我们自己的返回结果
     *
     * @param ret 个推返回结果
     * @return
     */
    private ResultModel<String> getChannelResult(IPushResult ret) {
        ResultModel<String> resultModel = new ResultModel<>();

        if (ret != null) {
            Map<String, Object> response = ret.getResponse();
            if (response.get("contentId") != null) {
                resultModel.setData(String.valueOf(response.get("contentId")));
            } else if (response.get("taskId") != null) {
                resultModel.setData(String.valueOf(response.get("taskId")));
            }
            if (response.get("status") != null) {
                resultModel.setMessage(String.valueOf(response.get("status")));
            } else {
                resultModel.setMessage(String.valueOf(response.get("result")));
            }
        } else {
            resultModel.setMessage(ErrorCode.FAIL.getMessage());
        }

        if (!StringUtils.isEmpty(resultModel.getData())) {
            resultModel.setCode(ErrorCode.SUCCESS.getCode());
        } else {
            resultModel.setCode(ErrorCode.FAIL.getCode());
        }

        return resultModel;
    }

}