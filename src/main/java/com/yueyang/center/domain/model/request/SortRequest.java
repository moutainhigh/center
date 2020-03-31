package com.yueyang.center.domain.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: live
 * @description: 排序请求
 * @author: qinxiangyang
 * @create: 2020-03-27 20:57
 **/
@Data
public class SortRequest {

    @ApiModelProperty(value = "主键id ")
    private Long id;

    @ApiModelProperty(value = "排序值")
    private Integer sort;
}