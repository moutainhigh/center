package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description: 现场类型
 * @author: qinxiangyang
 * @create: 2020-03-26 11:24
 **/
@Getter
public enum LiveTypeEnum {

    REPORT_LIVE("报道现场", 1),

    LINK_LIVE("外链现场", 2),;


    private final String name;
    private final Integer value;

    LiveTypeEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}