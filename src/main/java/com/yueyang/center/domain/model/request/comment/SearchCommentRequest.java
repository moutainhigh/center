package com.yueyang.center.domain.model.request.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: live
 * @description: 评论搜索参数
 * @author: qinxiangyang
 * @create: 2020-03-19 17:01
 **/
@Data
public class SearchCommentRequest {

    @ApiModelProperty(value = "开始时间")
    private Date startTime;

    @ApiModelProperty(value = "结束时间")
    private Date endTime;

    /**
     * 现场id/稿件id
     */
    @ApiModelProperty("现场id/稿件id")
    private Long relationId;
    /**
     * 状态 待审，启用，禁用
     */
    @ApiModelProperty(value = "状态 待审:0，启用:1，禁用:2")
    private Long status;

    /**
     * 评论来源
     */
    @ApiModelProperty(value = "评论来源，1：客户端，2：H5分享页，3：后台添加，4：后台批量添加")
    private Integer source;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String content;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;
    /**
     * 租户id
     */
    @ApiModelProperty(value = "租户id")
    private Long tenantId;

    /**
     * 稿件类型
     */
    @ApiModelProperty(value = "稿件类型 1稿件 2.现场 目前只有现场 必传2")
    private Integer type;
}