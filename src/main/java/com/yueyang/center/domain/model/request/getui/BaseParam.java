package com.yueyang.center.domain.model.request.getui;

import lombok.Data;

import java.util.Map;

@Data
public class BaseParam {

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String alert;

    /**
     * 应用自定义数据
     */
    private Map<String, Object> extras;
}
