package com.yueyang.center.domain.model.request.ApprovalLog;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-26 16:57
 **/
@Data
public class SearchApprovalLogRequest {

    /**
     * 类型 1.现场2.稿件
     */
    @ApiModelProperty(value = "类型 1.现场2.稿件,3,报道")
    private Integer type;

    /**
     * 业务id
     */
    @ApiModelProperty(value = "业务id")
    private Long bizId;


    /**
     * 状态 1待审2退回
     */
    @ApiModelProperty(value = "审核")
    private Integer status;


}