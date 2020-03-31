package com.yueyang.center.biz.impl;


import com.yueyang.center.domain.bo.ApprovalLogBO;
import com.yueyang.center.domain.entity.ApprovalLog;
import com.yueyang.center.service.IApprovalLogService;
import com.yueyang.center.utils.AdminContext;
import com.yueyang.center.utils.AdminInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-30 15:25
 **/
@Service
public class ApprovalLogBizImpl {


    @Autowired
    private IApprovalLogService approvalLogService;

    /**
     * 审核表
     *
     * @param approvalLogBO
     */

    public Boolean insertApprovalLog(ApprovalLogBO approvalLogBO) {
        ApprovalLog approvalLog = new ApprovalLog();
        AdminInfo adminInfo = AdminContext.getAdminInfo();
        approvalLog.setCreator(adminInfo.getAdminId());
        approvalLog.setModifier(adminInfo.getAdminId());
        approvalLog.setModifyTime(new Date());
        approvalLog.setCreateTime(new Date());
        approvalLog.setIssuer(approvalLogBO.getIssuer());
        approvalLog.setBizId(approvalLogBO.getId());
        approvalLog.setTenantId(adminInfo.getCurrentTenantId());
        approvalLog.setType(approvalLogBO.getType());
        approvalLog.setStatus(approvalLogBO.getStatus());
        approvalLog.setRemark(approvalLogBO.getRemark());
        Long aLong = approvalLogService.insert(approvalLog);
        if (aLong > 0) {
            return true;
        } else {
            return false;
        }
    }
}