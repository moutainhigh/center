package com.yueyang.center.domain.model.request.Live;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: live
 * @description: 退回
 * @author: qinxiangyang
 * @create: 2020-03-26 10:13
 **/
@Data
public class WithdrawRequest {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "id不能为空")
    private Long id;

    @ApiModelProperty(value = "退回理由")
    @NotNull(message = "退回理由不能为空")
    private String remark;
}