package com.yueyang.center.domain.model.request.reportroomuser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xwzhou
 * @date 2020-03-28 14:19
 */
@Data
public class ReportRoomUserSortRequest implements Serializable{
    private static final long serialVersionUID = -5112180632674354780L;

    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "排序值")
    private Long sort;
}
