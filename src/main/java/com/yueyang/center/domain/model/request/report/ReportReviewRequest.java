package com.yueyang.center.domain.model.request.report;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-19 22:32
 **/
public class ReportReviewRequest {
    /**
     * 报道状态 0草稿1待审2发布
     */
    @ApiModelProperty(value = "报道状态 0草稿1待审2发布")
    private String status;


}