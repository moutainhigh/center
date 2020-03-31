package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description: 报道类型
 * @author: qinxiangyang
 * @create: 2020-03-27 18:59
 **/
@Getter
public enum  ReportTypeEnum {
    LIVE("直播", 1),

    TRACE_REPORT("追踪报道", 2),
            ;



    private final String name;
    private final Integer value;

    ReportTypeEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

}