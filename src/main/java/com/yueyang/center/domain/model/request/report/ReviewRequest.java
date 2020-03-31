package com.yueyang.center.domain.model.request.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: live
 * @description: 审核
 * @author: qinxiangyang
 * @create: 2020-03-26 09:53
 **/
@Data
public class ReviewRequest {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "id不能为空")
    private Long id;

    @ApiModelProperty(value = "状态，")
    @NotNull(message = "审核状态不能为空")
    private Integer status;
}