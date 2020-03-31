package com.yueyang.center.domain.model.request.ApprovalLog;

import lombok.Data;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-26 16:29
 **/
@Data
public class ApprovalLogRequest {

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
}