package com.yueyang.center.domain.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-19 17:00
 **/
@Data
public class CommentPageResponse {
    @ApiModelProperty(value = "主键评论id")
    private Long id;

    /**
     * 评论者
     */
    @ApiModelProperty(value = "评论者昵称 ")
    private String nickName;
    /**
     * 评论者
     */
    @ApiModelProperty(value = "用户头像 ")
    private String icon;
    /**
     * 用户 类型
     */
    @ApiModelProperty(value = "用户类型 0记者 1专家 2订阅号 3 企业用户 4 普通用户 5主持人")
    private Integer userType;
    /**
     * 评论内容
     */

    @ApiModelProperty(value = "评论内容")
    private String content;
    /**
     * 稿件类型
     */
    @ApiModelProperty(value = "稿件类型 1稿件 2.现场")
    private Integer type;


    /**
     * 评论来源
     */
    @ApiModelProperty(value = "评论来源")
    private String source;
    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 状态 待审，启用，禁用
     */
    @ApiModelProperty(value = "评论适用 状态 删除:-1 待审:0，启用:1，禁用:2")
    private Long status;


    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 现场id/稿件id
     */
    @ApiModelProperty(value = "现场id/稿件id")

    private Long relationId;
    /**
     * 现场id/稿件id
     */
    @ApiModelProperty(value = "操作人")

    private String operator;


}