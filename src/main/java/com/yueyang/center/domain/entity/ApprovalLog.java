package com.yueyang.center.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 实体类
 * 签发表
 * </p>
 *
 * @author yyp
 * @since 2020-03-19
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "ApprovalLog", description = "签发表 ")
@AllArgsConstructor
public class ApprovalLog implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    private Long id;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Long modifier;

    /**
     * 更新时间
     */
    private Date modifyTime;


    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 类型 1.现场2.稿件
     */
    @ApiModelProperty(value = "类型 1.现场2.稿件3,报道")
    private Integer type;

    /**
     * 业务id
     */
    @ApiModelProperty(value = "业务id")
    private Long bizId;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 状态 1待审2发布
     */
    @ApiModelProperty(value = "状态 1待审2退回")
    private Integer status;

    /**
     * 签发人
     */
    @ApiModelProperty(value = "签发人")
    private Long issuer;


}

