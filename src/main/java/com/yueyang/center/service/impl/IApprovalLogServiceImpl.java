package com.yueyang.center.service.impl;

import com.yueyang.center.domain.bo.SearchApprovalLogBO;
import com.yueyang.center.domain.entity.ApprovalLog;
import com.yueyang.center.domain.mapper.IApprovalLogDAO;
import com.yueyang.center.service.IApprovalLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-26 13:20
 **/
@Service
public class IApprovalLogServiceImpl implements IApprovalLogService {


    @Resource
    private IApprovalLogDAO approvalLogDAO;

    @Override
    public Long insert(ApprovalLog approvalLog) {
        return approvalLogDAO.insert(approvalLog) > 0 ? approvalLog.getId() : 0L;

    }

    @Override
    public List<ApprovalLog> list(SearchApprovalLogBO searchApprovalLogRequest) {
        return approvalLogDAO.list(searchApprovalLogRequest);
    }


}