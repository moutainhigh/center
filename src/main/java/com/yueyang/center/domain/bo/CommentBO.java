package com.yueyang.center.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: gusteau-live
 * @description:
 * @author: whl
 * @create: 2020-03-27 15:52
 **/
@Data
public class CommentBO {
    @ApiModelProperty("开始时间")
    Date startTime;

    @ApiModelProperty("结束时间")
    Date endTime;

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

    @ApiModelProperty(value = "发送人 随机用户、署名作者")

    private Long commentator;
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
