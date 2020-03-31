package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-26 14:47
 **/
@Getter
public enum LiveListEnum {

    MY_LIVE("我的现场", 1),

    PENDING_LIVE("待签现场", 2),

    PUBLISH_LIVE("成品现场", 3),;

    private final String name;
    private final Integer value;

    LiveListEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}