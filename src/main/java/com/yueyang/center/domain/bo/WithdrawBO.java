package com.yueyang.center.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 16:37
 **/
@Data
public class WithdrawBO {
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