package com.yueyang.center.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 实体类
 * 评论表
 * </p>
 *
 * @author yyp
 * @since 2020-03-19
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "Comment", description = "评论表 ")
@AllArgsConstructor
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    private Long id;


    @ApiModelProperty(value = "创建时间")
    private LocalDate createTime;

    @ApiModelProperty(value = "修改人")
    private Long modifier;

    @ApiModelProperty(value = "修改时间")
    private LocalDate modifyTime;


    @ApiModelProperty(value = "租户id")
    private Long tenantId;

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
    @ApiModelProperty(value = "用户类型 0记者 1专家 2订阅号 3 企业用户 4 普通用户")
    private Integer userType;
    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    @Length(max = 1024, message = "评论内容长度不能超过1024")
    private String content;

    @ApiModelProperty(value = "内容标题")
    private String title;
    /**
     * 评论来源
     */
    @ApiModelProperty(value = "评论来源")

    private Integer source;

    /**
     * 现场id/稿件id
     */
    @ApiModelProperty(value = "现场id/稿件id")

    private Long relationId;

    /**
     * 状态 待审，启用，禁用
     */
    @ApiModelProperty(value = "状态 待审:0，启用:1，禁用:2")

    private Integer status;

    /**
     * 发送人 随机用户、署名作者
     */
    @ApiModelProperty(value = "发送人 随机用户、署名作者")

    private Long commentator;




    /**
     * 类型 1稿件2现场
     */
    @ApiModelProperty(value = "类型 1: 稿件,2: 现场")
    private Integer type;


}

