package com.yueyang.center.domain.model.request.getui;

import lombok.Data;

@Data
public class ToSingleParam extends BaseParam {
    /**
     * 设备id
     */
    private String clientId;
}
