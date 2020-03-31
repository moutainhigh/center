package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description: 现场所处的状态
 * @author: qinxiangyang
 * @create: 2020-03-26 11:11
 **/
@Getter
public enum LiveStatusEnum {

    DRAFT("草稿", 1),

    PENDING("待审", 2),

    PUBLISH("成品", 3),

    WITHDRAW("退回", 4),

    DELETE("删除", 5),;

    private final String name;
    private final Integer value;

    LiveStatusEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}