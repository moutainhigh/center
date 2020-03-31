package com.yueyang.center.domain.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xwzhou
 * @date 2020-03-27 22:00
 */
@Data
public class AreaRequest implements Serializable {
    private static final long serialVersionUID = 8335439905830592914L;

    @ApiModelProperty("父节点 id")
    private Long parentId;
}
