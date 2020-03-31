package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 20:44
 **/
@Getter
public enum FixedEnum {
    FIX("固定", 1),

    NON_FIX("取消固定", 0),;


    private final String name;
    private final Integer value;

    FixedEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}