package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-26 13:27
 **/
@Getter
public enum ApprovalLogTypeEnum {
    LIVE("现场", 1),

    NEWS("新闻", 2),
    REPORT("报道", 3),;

    private final String name;
    private final Integer value;

    ApprovalLogTypeEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}