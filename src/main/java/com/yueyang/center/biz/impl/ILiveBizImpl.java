package com.yueyang.center.biz.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yueyang.center.biz.ILiveBiz;
import com.yueyang.center.domain.bo.*;
import com.yueyang.center.domain.entity.ApprovalLog;
import com.yueyang.center.domain.entity.Live;
import com.yueyang.center.domain.model.IdRequest;
import com.yueyang.center.domain.model.PageResult;
import com.yueyang.center.domain.model.PageWrapper;
import com.yueyang.center.domain.model.request.Live.*;
import com.yueyang.center.domain.model.response.Live.LivePageResponse;
import com.yueyang.center.domain.model.response.Live.LiveResponse;
import com.yueyang.center.enums.*;
import com.yueyang.center.exception.LiveException;
import com.yueyang.center.service.IApprovalLogService;
import com.yueyang.center.service.ILiveService;
import com.yueyang.center.utils.AdminContext;
import com.yueyang.center.utils.AdminInfo;
import com.yueyang.center.utils.DozerUtils;
import com.yueyang.center.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @program: center
 * @description: 业务实现
 * @author: qinxiangyang
 * @create: 2020-03-31 20:57
 **/
@Service
public class ILiveBizImpl implements ILiveBiz {
    @Autowired
    private ILiveService liveService;

    @Autowired
    private IApprovalLogService approvalLogService;

    @Autowired
    private ApprovalLogBizImpl approvalLogBiz;

    /**
     * 现场列表
     */
    @Override
    public PageResult<LivePageResponse> list(PageWrapper<LivePageRequest> request) {
        //校验参数
        LivePageRequest condition = request.getCondition();
        LivePageBO livePageBO = DozerUtils.mapper(condition, LivePageBO.class);
        validPageRequest(livePageBO);

        //封装参数
        pageRequestHandle(condition, livePageBO);

        //分页参数封装
        PageHelper.startPage(request.getCurrent(), request.getSize());
        List<Live> liveLists = liveService.list(livePageBO);
        PageInfo<Live> pageInfo = new PageInfo<>(liveLists);
        PageResult<LivePageResponse> pageResult = PageUtils.toPageResult(pageInfo, live -> {
            LivePageResponse livePageResponse = DozerUtils.mapper(live, LivePageResponse.class);
            if (!ObjectUtils.isEmpty(getNewsAuthorRequests(live))) {
                livePageResponse.setNewsAuthors(getNewsAuthorRequests(live));
            }
            return livePageResponse;
        });

        return pageResult;
    }

    /**
     * 新闻作者封装
     *
     * @param live
     * @return
     */
    private List<NewsAuthorRequest> getNewsAuthorRequests(Live live) {
        String newsAuthor = live.getNewsAuthor();
        List<NewsAuthorRequest> newsAuthorRequests = null;
        if (!StringUtils.isEmpty(newsAuthor)) {
            newsAuthorRequests = JSONArray.parseArray(live.getNewsAuthor(), NewsAuthorRequest.class);
        }
        return newsAuthorRequests;
    }

    private void pageRequestHandle(LivePageRequest request, LivePageBO condition) {
        Integer interfaceType = condition.getInterfaceType();
        if (LiveListEnum.MY_LIVE.getValue().equals(interfaceType)) {
            AdminInfo adminInfo = AdminContext.getAdminInfo();
            condition.setCreator(adminInfo.getAdminId());

        }
        if (LiveListEnum.PENDING_LIVE.getValue().equals(interfaceType)) {
            condition.setStatus(LiveStatusEnum.PENDING.getValue());
        }
        if (LiveListEnum.PUBLISH_LIVE.getValue().equals(interfaceType)) {
            condition.setStatus(LiveStatusEnum.PUBLISH.getValue());
        }
        condition.setTenantId(AdminContext.getAdminInfo().getCurrentTenantId());
        //对时间的处理
        String startTimee = request.getStartTimee();
        if (!StringUtils.isEmpty(startTimee)) {
            startTimee = startTimee + " 00:00:00";
            Date date = parseTimeString2Date(startTimee);
            condition.setStartTime(date);
        }
        String endTimee = request.getEndTimee();
        if (!StringUtils.isEmpty(endTimee)) {
            endTimee = endTimee + " 23:59:59";
            Date date = parseTimeString2Date(endTimee);
            condition.setEndTime(date);
        }

    }


    public static Date parseTimeString2Date(String timeString) {

        Date date = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = new Date(dateFormat.parse(timeString).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 分页参数校验
     *
     * @param condition
     */
    private void validPageRequest(LivePageBO condition) {
        if (ObjectUtils.isEmpty(condition)) {
            throw new LiveException(LiveErrorCodeEnum.OBJECT_IS_NULL);
        }
        if (ObjectUtils.isEmpty(condition.getInterfaceType())) {
            throw new LiveException(LiveErrorCodeEnum.LIVE_LIST_TYPE_ISNULL);
        }
    }


    /**
     * 详情
     *
     * @param idRequest
     * @return
     */
    @Override
    public LiveResponse detail(IdRequest idRequest) {
        IdBO idBO = DozerUtils.mapper(idRequest, IdBO.class);
        //校验
        validIdRequest(idBO);

        Live live = liveService.findById(idRequest.getId());
        if (ObjectUtils.isEmpty(live)) {
            throw new LiveException(LiveErrorCodeEnum.LIVE_NOT_EXIT);
        }
        LiveResponse liveResponse = DozerUtils.mapper(live, LiveResponse.class);
        liveResponse.setNewsAuthors(getNewsAuthorRequests(live));

        if (LiveStatusEnum.WITHDRAW.getValue().equals(live.getStatus())) {
            SearchApprovalLogBO searchApprovalLogBO = new SearchApprovalLogBO();
            searchApprovalLogBO.setBizId(live.getId());
            searchApprovalLogBO.setStatus(ApprovalLogStatusEnum.WITHDRAW.getValue());
            searchApprovalLogBO.setType(ApprovalLogTypeEnum.LIVE.getValue());
            List<ApprovalLog> approvalLogs = approvalLogService.list(searchApprovalLogBO);
            if (!CollectionUtils.isEmpty(approvalLogs)) {
                liveResponse.setReason(approvalLogs.get(0).getRemark());
            }

        }
        return liveResponse;
    }

    private void validIdRequest(IdBO idRequest) {
        if (ObjectUtils.isEmpty(idRequest) || ObjectUtils.isEmpty(idRequest.getId())) {
            throw new LiveException(LiveErrorCodeEnum.OBJECT_IS_NULL);
        }
    }

    /**
     * 创建
     *
     * @param request
     * @return
     */
    @Override
    public Long create(LiveRequest request) {
        LiveBO liveBO = DozerUtils.mapper(request, LiveBO.class);
        validLiveBO(liveBO, null);
        if (!CollectionUtils.isEmpty(request.getNewsAuthors())) {
            Object obj = request.getNewsAuthors();
            String jsonString = JSON.toJSONString(obj);
            liveBO.setNewsAuthor(jsonString);
        }
        Live live = DozerUtils.mapper(liveBO, Live.class);
        liveCreateHandle(liveBO, live);

        //通过判断状态审核表的插入
        Long count = liveService.insert(live);
        if (!ObjectUtils.isEmpty(count) && count > 0) {
            //对状态进行判断
            liveBO.setId(count);
            if (LiveStatusEnum.PUBLISH.getValue().equals(liveBO.getStatus())) {
                //插入审核表
                ApprovalLogBO approvalLogRequest = getApprovalLogRequest(liveBO.getId());
                approvalLogBiz.insertApprovalLog(approvalLogRequest);
            }
        }
        return count;
    }

    /**
     * 现场参数创建校验
     *
     * @param liveBO
     */
    private void validLiveBO(LiveBO liveBO, Live live) {
        //校验标题
        CheckTitleBO checkTitleBO = new CheckTitleBO();
        checkTitleBO.setTenantId(AdminContext.getAdminInfo().getAdminId());
        String title = liveBO.getTitle();
        if (StringUtils.isEmpty(title)) {
            throw new LiveException(LiveErrorCodeEnum.LIVE_TITLE_ISNULL);
        }
        checkTitleBO.setTitle(title);
        if (ObjectUtils.isEmpty(live)) {
            //创建
            List<Live> lives = liveService.checkTitle(checkTitleBO);
            if (!CollectionUtils.isEmpty(lives)) {
                throw new LiveException(LiveErrorCodeEnum.LIVE_TITLE_EXIT);
            }
        } else {
            //编辑
            if (!live.getTitle().equals(liveBO.getTitle())) {
                List<Live> lives = liveService.checkTitle(checkTitleBO);
                if (!CollectionUtils.isEmpty(lives) && lives.size() > 1) {
                    throw new LiveException(LiveErrorCodeEnum.LIVE_TITLE_EXIT);
                }
            }
        }

    }

    private void liveCreateHandle(LiveBO liveBO, Live live) {

        live.setTenantId(AdminContext.getAdminInfo().getCurrentTenantId());
        live.setCreator(AdminContext.getAdminInfo().getAdminId());
        live.setModifier(AdminContext.getAdminInfo().getAdminId());
        live.setCreateTime(new Date());
        live.setModifyTime(new Date());
        live.setOffline(OfflineEnum.OFFLINE.getValue());
    }


    /**
     * 更新
     *
     * @param request
     * @return
     */
    @Override
    public Boolean update(LiveRequest request) {
        LiveBO liveBO = DozerUtils.mapper(request, LiveBO.class);
        //判断现场是否存在
        Live live = liveService.findById(liveBO.getId());
        if (!ObjectUtils.isEmpty(request.getNewsAuthors())) {
            liveBO.setNewsAuthor(JSON.toJSONString(request.getNewsAuthors()));
        }
        validLiveBO(liveBO, live);
        if (ObjectUtils.isEmpty(live)) {
            throw new LiveException(LiveErrorCodeEnum.LIVE_NOT_EXIT);
        }
        Live liveMapper = DozerUtils.mapper(liveBO, Live.class);
        liveMapper.setModifyTime(new Date());
        Boolean count = liveService.update(liveMapper);
        if (count) {
            //审核表
            if (validUpdateStatus(live.getStatus())) {
                ApprovalLogBO approvalLogRequest = getApprovalLogRequest(liveBO.getId());
                approvalLogBiz.insertApprovalLog(approvalLogRequest);
            }
        }
        return count;
    }

    private Boolean validUpdateStatus(Integer status) {
        if (ObjectUtils.isEmpty(status) || status < 0 || status > 5) {
            return false;
        }
        if (LiveStatusEnum.DRAFT.getValue().equals(status) || LiveStatusEnum.PENDING.getValue().equals(status) || LiveStatusEnum.WITHDRAW.getValue().equals(status)) {
            return true;
        }
        return false;
    }

    /**
     * 删除
     *
     * @param request
     * @return
     */
    @Override
    public Boolean delete(IdRequest request) {
        IdBO idBO = DozerUtils.mapper(request, IdBO.class);
        validIdRequest(idBO);
        return liveService.delete(idBO);
    }

    @Override
    public Boolean oneKeyPublish(IdRequest request) {
        IdBO idBO = DozerUtils.mapper(request, IdBO.class);
        validIdRequest(idBO);

        //主表的修改
        Long id = idBO.getId();
        Live live = liveService.findById(id);
        if (ObjectUtils.isEmpty(live)) {
            throw new LiveException(LiveErrorCodeEnum.LIVE_NOT_EXIT);
        }
        OneKeyPublishBO oneKeyPublishRquest = new OneKeyPublishBO();
        oneKeyPublishRquest.setStatus(LiveStatusEnum.PUBLISH.getValue());
        oneKeyPublishRquest.setId(live.getId());
        Boolean bool = liveService.oneKeyPublish(oneKeyPublishRquest);

        if (bool) {
            //日志表的插入
            ApprovalLogBO approvalLogRequest = getApprovalLogRequest(idBO.getId());
            approvalLogBiz.insertApprovalLog(approvalLogRequest);
        }

        return bool;
    }

    /**
     * 下线/上线
     */
    @Override
    public Boolean offline(OfflineRequest request) {
        OfflineBO offlineBO = DozerUtils.mapper(request, OfflineBO.class);
        return liveService.offline(offlineBO);
    }


    /**
     * 审核
     *
     * @param request
     * @return
     */
    @Override
    public Boolean review(IdRequest request) {

        ReviewBO reviewBO = DozerUtils.mapper(request, ReviewBO.class);
        //主表的修改
        Long id = reviewBO.getId();
        Live live = liveService.findById(id);
        if (ObjectUtils.isEmpty(live)) {
            throw new LiveException(LiveErrorCodeEnum.LIVE_NOT_EXIT);
        }
        Live reviewLive = new Live();
        reviewLive.setStatus(LiveStatusEnum.PUBLISH.getValue());
        reviewLive.setModifier(AdminContext.getAdminInfo().getAdminId());
        reviewLive.setModifyTime(new Date());
        reviewLive.setId(live.getId());
        Boolean bool = liveService.update(reviewLive);

        if (bool) {
            //日志表的插入
            ApprovalLogBO approvalLogRequest = getApprovalLogRequest(reviewBO.getId());
            approvalLogBiz.insertApprovalLog(approvalLogRequest);
        }

        return bool;
    }

    /**
     * 提交审核
     *
     * @param request
     * @return
     */
    @Override
    public Boolean submitReview(IdRequest request) {

        ReviewBO reviewBO = DozerUtils.mapper(request, ReviewBO.class);
        //主表的修改
        Long id = reviewBO.getId();
        Live live = liveService.findById(id);
        if (ObjectUtils.isEmpty(live)) {
            throw new LiveException(LiveErrorCodeEnum.LIVE_NOT_EXIT);
        }
        Live reviewLive = new Live();
        reviewLive.setStatus(LiveStatusEnum.PENDING.getValue());
        reviewLive.setModifier(AdminContext.getAdminInfo().getAdminId());
        reviewLive.setModifyTime(new Date());
        reviewLive.setId(live.getId());


        return liveService.update(reviewLive);

    }

    private ApprovalLogBO getApprovalLogRequest(Long id) {
        ApprovalLogBO approvalLogRequest = new ApprovalLogBO();
        approvalLogRequest.setId(id);
        approvalLogRequest.setIssuer(AdminContext.getAdminInfo().getAdminId());
        approvalLogRequest.setStatus(ApprovalLogStatusEnum.REVIEW.getValue());
        approvalLogRequest.setType(ApprovalLogTypeEnum.LIVE.getValue());
        return approvalLogRequest;
    }

    /**
     * 退回
     *
     * @param request
     * @return
     */
    @Override
    public Boolean withdraw(WithdrawRequest request) {

        WithdrawBO withdrawBO = DozerUtils.mapper(request, WithdrawBO.class);
        //主表的修改
        Long id = withdrawBO.getId();
        Live live = liveService.findById(id);
        if (ObjectUtils.isEmpty(live)) {
            throw new LiveException(LiveErrorCodeEnum.LIVE_NOT_EXIT);
        }
        Live reviewLive = new Live();
        reviewLive.setStatus(LiveStatusEnum.WITHDRAW.getValue());
        reviewLive.setModifier(AdminContext.getAdminInfo().getAdminId());
        reviewLive.setModifyTime(new Date());
        reviewLive.setId(live.getId());
        Boolean bool = liveService.update(reviewLive);

        if (bool) {
            //日志表的插入
            ApprovalLogBO approvalLogRequest = getApprovalLogRequest(withdrawBO, live);
            approvalLogBiz.insertApprovalLog(approvalLogRequest);
        }
        return null;
    }

    /**
     * 排序列表
     *
     * @param
     * @return
     */
    @Override
    public PageResult<LivePageResponse> sortList(PageWrapper<SearchLiveSortRequest> searchLiveSortRequest) {

        //校验参数
        SearchLiveSortRequest condition = searchLiveSortRequest.getCondition();
        if (ObjectUtils.isEmpty(condition)) {
            throw new LiveException(LiveErrorCodeEnum.OBJECT_IS_NULL);
        }
        SearchLiveSortBO searchLiveSortBO = DozerUtils.mapper(condition, SearchLiveSortBO.class);


        //封装参数
        searchLiveSortBO.setStatus(LiveStatusEnum.PUBLISH.getValue());
        searchLiveSortBO.setTenantId(AdminContext.getAdminInfo().getCurrentTenantId());


        //分页参数封装
        PageHelper.startPage(searchLiveSortRequest.getCurrent(), searchLiveSortRequest.getSize());
        List<Live> liveLists = liveService.sortList(searchLiveSortBO);
        PageInfo<Live> pageInfo = new PageInfo<>(liveLists);
        PageResult<LivePageResponse> pageResult = PageUtils.toPageResult(pageInfo, live -> {
            LivePageResponse livePageResponse = DozerUtils.mapper(live, LivePageResponse.class);
            livePageResponse.setNewsAuthors(getNewsAuthorRequests(live));

            return livePageResponse;
        });

        return pageResult;

    }

    /**
     * 退会日志参数封装
     *
     * @param request
     * @param live
     * @return
     */
    private ApprovalLogBO getApprovalLogRequest(WithdrawBO request, Live live) {
        ApprovalLogBO approvalLogRequest = new ApprovalLogBO();
        approvalLogRequest.setId(request.getId());
        //需要查询
        SearchApprovalLogBO searchApprovalLogRequest = new SearchApprovalLogBO();
        searchApprovalLogRequest.setBizId(live.getId());
        searchApprovalLogRequest.setStatus(ApprovalLogStatusEnum.REVIEW.getValue());
        searchApprovalLogRequest.setType(ApprovalLogTypeEnum.LIVE.getValue());
        List<ApprovalLog> list = approvalLogService.list(searchApprovalLogRequest);
        if (!CollectionUtils.isEmpty(list)) {
            ApprovalLog approvalLog = list.get(0);
            approvalLogRequest.setIssuer(approvalLog.getIssuer());
        } else {
            approvalLogRequest.setIssuer(live.getModifier());
        }
        approvalLogRequest.setStatus(ApprovalLogStatusEnum.WITHDRAW.getValue());
        approvalLogRequest.setRemark(request.getRemark());
        approvalLogRequest.setType(ApprovalLogTypeEnum.LIVE.getValue());
        return approvalLogRequest;
    }


    /**
     * 排序
     *
     * @param sortRequest
     * @return
     */
    @Override
    public Boolean sort(SortRequest sortRequest) {
        //校验参数
        validSortRequest(sortRequest);

        return null;
    }

    private void validSortRequest(SortRequest sortRequest) {
    }
}