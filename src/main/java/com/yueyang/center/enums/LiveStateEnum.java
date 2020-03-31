package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description: 现场状态
 * @author: qinxiangyang
 * @create: 2020-03-26 11:30
 **/
@Getter
public enum LiveStateEnum {
    TEASER("预告", 1),

    LIVING("直播中", 2),

    REPLAY("回放", 3),;

    private final String name;
    private final Integer value;

    LiveStateEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}