package com.yueyang.center.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 16:54
 **/
@Data
public class OneKeyPublishBO {
    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "成品现场，待签现场使用，现场状态  1草稿，2待审，3成品，4退回，5删除")
    private Integer status;
}