package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 15:08
 **/
@Getter
public enum ReportStatusEnum {

    DRAFT("草稿", 1),

    PENDING("待审", 2),

    PUBLISH("成品", 3),

    WITHDRAW("退回", 4),

    DELETE("删除", 5),;

    private final String name;
    private final Integer value;

    ReportStatusEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}