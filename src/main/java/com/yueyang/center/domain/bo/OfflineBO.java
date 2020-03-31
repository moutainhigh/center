package com.yueyang.center.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 16:45
 **/
@Data
public class OfflineBO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotEmpty(message = "id不能为空")
    private Long id;


    @ApiModelProperty(value = "上线/下线 1:上线，2：下线")
    @Range(min = 1, max = 2, message = "1:上线，2：下线")
    private Integer offline;
}