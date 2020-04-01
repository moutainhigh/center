package com.yueyang.center.domain.model.request.getui;

import lombok.Getter;

@Getter
public enum PushDeviceEnum {
    /**
     * IOS设备
     */
    IOS(1, "IOS"),

    /**
     * Android设备
     */
    ANDROID(2, "ANDROID");

    private int key;
    private String value;

    private PushDeviceEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
