package com.yueyang.center.domain.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 询问专家是否加入直播间
 *
 * @author yangyongping
 */
@Data
public class RoomInquiryRequest {

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("报道id")
    private Long reportId;

    @ApiModelProperty("同意:2拒绝  1同意")
    private Integer status;
}
