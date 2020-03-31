package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 15:08
 **/
@Getter
public enum ReportRoomEnum {

    CONNECTION_PASS("连线通过", 1),
    CONNECTION_REJECT("连线拒绝", 2),
    AUDIO_ON("音频打开", 3),
    AUDIO_OFF("音频关闭", 4),
    VIDEO_ON("视频打开", 5),
    VIDEO_OFF("视频关闭", 6),
    JOIN_ON("加入大屏打开", 7),
    JOIN_OFF("加入大屏关闭", 8),
    DIS_CONNECT("用户(专家)主动断开连接", 9),
    CAT_CONNECT("切断用户连接", 10),
    CONNECTION_BATCH("批量建立连接", 11),
    CONNECTION_SINGLE("建立单个连接", 12),
    ;

    private final String name;
    private final Integer value;

    ReportRoomEnum(String name, Integer value) {
        this.name = name;
        this.value = value;
    }
}