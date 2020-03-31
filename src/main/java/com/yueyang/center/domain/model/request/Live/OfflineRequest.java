package com.yueyang.center.domain.model.request.Live;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-26 16:16
 **/
@Data
public class OfflineRequest {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    @NotNull(message = "id不能为空")
    private Long id;


    @ApiModelProperty(value = "上线/下线 1:上线，2：下线")
    @Range(min = 1, max = 2, message = "1:上线，2：下线")
    private Integer offline;
}