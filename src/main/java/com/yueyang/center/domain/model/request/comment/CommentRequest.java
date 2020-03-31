package com.yueyang.center.domain.model.request.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @program: live
 * @description: 评论创建，编辑
 * @author: qinxiangyang
 * @create: 2020-03-19 16:42
 **/
@Data
public class CommentRequest {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id 即评论id")
    private Long id;

    @ApiModelProperty(value = "租户id")
    private Long tenantId;
    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    @Length(max = 1024, message = "评论内容长度不能超过1024")
    private String content;
    /**
     * 现场id/稿件id
     */
    @ApiModelProperty(value = "现场id/稿件id 目前只有现场")
    private Long relationId;
    /**
     * 发送类型
     */
    @ApiModelProperty(value = "发送类型 1 随即用户 2 署名作者")
    @NotNull(message = "请选择发送人类型")
    private Integer commentatorType;


    /**
     * 类型 1稿件2现场
     */
    @ApiModelProperty(value = "类型 1: 稿件,2: 现场  目前只有现场 传2")
    private Integer type;
    /**
     * 类型 1稿件2现场
     */
    @ApiModelProperty(value = "类型 1: 稿件,2: 现场  目前只有现场 传2")
    private String title;

}