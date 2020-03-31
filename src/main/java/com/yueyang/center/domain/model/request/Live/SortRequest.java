package com.yueyang.center.domain.model.request.Live;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: usercenter
 * @description: 排序的请求参数
 * @author: qinxiangyang
 * @create: 2020-03-18 18:52
 **/
@Data
public class SortRequest {

        @ApiModelProperty("排序id")
        private Long id;

        @ApiModelProperty("排序值")
        private Integer sort;

}