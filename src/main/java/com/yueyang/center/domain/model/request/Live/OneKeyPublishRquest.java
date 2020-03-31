package com.yueyang.center.domain.model.request.Live;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 14:56
 **/
@Data
public class OneKeyPublishRquest {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "成品现场，待签现场使用，现场状态  1草稿，2待审，3成品，4退回，5删除")
    private Integer status;
}