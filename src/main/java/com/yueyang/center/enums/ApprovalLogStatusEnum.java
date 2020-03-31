package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-26 13:25
 **/
@Getter
public enum ApprovalLogStatusEnum {
    REVIEW("审核", 1),

    WITHDRAW("退回", 2),;

    private final String name;
    private final Integer value;

    ApprovalLogStatusEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}