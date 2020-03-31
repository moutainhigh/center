package com.yueyang.center.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 21:11
 **/
@Data
public class CheckTitleBO {

    @ApiModelProperty(value = "tenantId")
    private Long tenantId;

    @ApiModelProperty(value = "title")
    private String title;
}