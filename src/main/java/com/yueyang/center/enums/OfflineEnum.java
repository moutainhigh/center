package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 20:42
 **/
@Getter
public enum  OfflineEnum {


    ONLINE("上线", 1),

    OFFLINE("下线", 2),
    ;



    private final String name;
    private final Integer value;

    OfflineEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}