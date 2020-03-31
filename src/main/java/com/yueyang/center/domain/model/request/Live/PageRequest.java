package com.yueyang.center.domain.model.request.Live;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: usercenter
 * @description: 分页公共部分
 * @author: wxy
 * @create: 2020-03-18 18:13
 **/
@Data
public class PageRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("当前页数")
    private int current = 1;

    @ApiModelProperty("每页条数")
    private int size = 20;


}
