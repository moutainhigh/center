package com.yueyang.center.biz;

import com.yueyang.center.domain.model.IdRequest;
import com.yueyang.center.domain.model.PageResult;
import com.yueyang.center.domain.model.PageWrapper;
import com.yueyang.center.domain.model.request.Live.*;
import com.yueyang.center.domain.model.response.Live.LivePageResponse;
import com.yueyang.center.domain.model.response.Live.LiveResponse;

/**
 * @program: center
 * @description: 现场管理业务接口
 * @author: qinxiangyang
 * @create: 2020-03-31 20:55
 **/
public interface ILiveBiz {
    /**
     * 现场列表
     */
    PageResult<LivePageResponse> list(PageWrapper<LivePageRequest> request);

    /**
     * 详情
     *
     * @param id
     * @return
     */
    LiveResponse detail(IdRequest id);


    /**
     * 创建
     *
     * @param request
     * @return
     */
    Long create(LiveRequest request);

    /**
     * 更新
     *
     * @param request
     * @return
     */
    Boolean update(LiveRequest request);

    /**
     * 删除
     *
     * @param request
     * @return
     */
    Boolean delete(IdRequest request);


    /**
     * 一键成品
     */
    Boolean oneKeyPublish(IdRequest request);


    /**
     * 下线/上线
     */
    Boolean offline(OfflineRequest request);

    /**
     * 审核
     *
     * @param request
     * @return
     */

    Boolean review(IdRequest request);

    /**
     * 提交审核
     *
     * @param request
     * @return
     */

    Boolean submitReview(IdRequest request);

    /**
     * 退回
     *
     * @param request
     * @return
     */

    Boolean withdraw(WithdrawRequest request);

    /**
     * 排序列表
     *
     * @param request
     * @return
     */
    PageResult<LivePageResponse> sortList(PageWrapper<SearchLiveSortRequest> request);

    /**
     * 排序
     *
     * @param sortRequest
     * @return
     */
    Boolean sort(SortRequest sortRequest);
}