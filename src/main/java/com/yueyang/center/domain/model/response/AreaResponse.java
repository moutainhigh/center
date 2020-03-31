package com.yueyang.center.domain.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xwzhou
 * @date 2020-03-27 22:01
 */
@Data
public class AreaResponse implements Serializable{
    private static final long serialVersionUID = 3292484872205960930L;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 父类code
     */
    @ApiModelProperty(value = "父类code")
    private Long parentId;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
}
