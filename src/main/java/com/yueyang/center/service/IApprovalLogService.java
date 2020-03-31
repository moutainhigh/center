package com.yueyang.center.service;


import com.yueyang.center.domain.bo.SearchApprovalLogBO;
import com.yueyang.center.domain.entity.ApprovalLog;

import java.util.List;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-26 13:20
 **/
public interface IApprovalLogService {

    Long insert(ApprovalLog approvalLog);

    List<ApprovalLog> list(SearchApprovalLogBO searchApprovalLogRequest);


}