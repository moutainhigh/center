package com.yueyang.center.domain.model.request.getui;

import lombok.Data;

import java.util.List;

@Data
public class ToListParam extends BaseParam {

    /**
     * 设备id列表
     */
    private List<String> clientIds;
}
