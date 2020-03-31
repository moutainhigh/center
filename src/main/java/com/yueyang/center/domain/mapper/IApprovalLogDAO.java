package com.yueyang.center.domain.mapper;


import com.yueyang.center.domain.bo.SearchApprovalLogBO;
import com.yueyang.center.domain.entity.ApprovalLog;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * 签发表
 * </p>
 *
 * @author yyp
 * @date 2020-03-19
 */
public interface IApprovalLogDAO {
    /**
     * 保存单一对象  如果采用集中式的ID生成,传入的entity ID属性有值;如果使用数据库的自增ID,传入的entity ID属性无值
     *
     * @param approvalLog
     * @return 主键ID
     */
    Long insert(ApprovalLog approvalLog);


    List<ApprovalLog> list(SearchApprovalLogBO searchApprovalLogRequest);

}
