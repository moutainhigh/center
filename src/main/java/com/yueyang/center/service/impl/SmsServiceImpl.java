package com.yueyang.center.service.impl;

import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.yueyang.center.contant.Constant;
import com.yueyang.center.service.ISmsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @program: gusteau-live
 * @description: 发送短信实现类
 * @author: qxy
 * @create: 2020-03-31 11:34
 **/
@Service
@Slf4j
public class SmsServiceImpl implements ISmsService {
    @Autowired
    IAcsClient acsClient;

    @Override
    public boolean sendSms(String phone, String code) {
        // 组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        // 必填:待发送手机号
        request.setPhoneNumbers(phone);
        // 必填:短信签名-可在短信控制台中找到
        request.setSignName(Constant.SignName);
        // 必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(Constant.SMS_CODE);
        // 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        request.setTemplateParam(String.format("{\"code\":\"%s\"}", code));
        // hint 此处可能会抛出异常，注意catch
        try {
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (ObjectUtils.isEmpty(sendSmsResponse)
                    && !StringUtils.equals(sendSmsResponse.getCode(), Constant.RESPONSE_SUCCESS)) {
                log.error(String.format("send sms err phone:%s,code:%s,msg:%s", phone, code,
                        sendSmsResponse.getMessage()));
                return false;
            }
        } catch (ClientException e) {
            log.info(e.getErrMsg());
            return false;
        }
        return true;
    }
}