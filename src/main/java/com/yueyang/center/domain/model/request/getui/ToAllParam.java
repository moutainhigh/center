package com.yueyang.center.domain.model.request.getui;

import lombok.Data;

import java.util.Set;

@Data
public class ToAllParam extends BaseParam {
    /**
     * 推送设备
     */
    private Set<PushDeviceEnum> devices;
}
