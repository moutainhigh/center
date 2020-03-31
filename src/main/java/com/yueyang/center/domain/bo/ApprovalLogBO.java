package com.yueyang.center.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 16:35
 **/
@Data
public class ApprovalLogBO {
    /**
     * id
     */

    private Long id;

    /**
     * 退回理由
     */
    private String remark;

    /**
     * 签发人
     */
    private Long issuer;

    /**
     * 状态
     */
    private Integer status;

    @ApiModelProperty(value = "类型 1.现场2.稿件3,报道")
    private Integer type;
}