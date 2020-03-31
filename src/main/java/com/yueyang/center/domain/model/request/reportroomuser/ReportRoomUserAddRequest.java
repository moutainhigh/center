package com.yueyang.center.domain.model.request.reportroomuser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xwzhou
 * @date 2020-03-28 15:07
 */
@Data
public class ReportRoomUserAddRequest implements Serializable{
    private static final long serialVersionUID = -784358614307326107L;
    @ApiModelProperty(value = "用户 userId")
    private Long userId;

    @ApiModelProperty(value = "报导 reportId")
    private Long reportId;
}
