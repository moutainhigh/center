package com.yueyang.center.domain.model.request.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 20:46
 **/
@Data
public class FixRequest {

    @ApiModelProperty("报道id")
    @NotNull(message = "报道id不能为空")
    private Long id;

    @ApiModelProperty("固定 1：固定，0：取消固定")
    @Range(min = 1, max = 2, message = "1：固定，0：取消固定")
    @NotNull(message = "固定的状态不能为空")
    private Integer fixed;
}