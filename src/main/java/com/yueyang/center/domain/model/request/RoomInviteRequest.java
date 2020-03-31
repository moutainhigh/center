package com.yueyang.center.domain.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 专家列表
 *
 * @author yangyongping
 */
@Data
public class RoomInviteRequest {
    @ApiModelProperty("报道id")
    private Long reportId;


    @ApiModelProperty("专家id列表")
    private List<Long> userIds;
}
