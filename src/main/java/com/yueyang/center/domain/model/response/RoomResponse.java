package com.yueyang.center.domain.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author yangyongping
 */
@Data
public class RoomResponse {

    @ApiModelProperty("房间号:阿里api的-ChannelID")
    private Long roomId;
    @ApiModelProperty("用户标识:阿里api的-UserID")
    private String userId;
    @ApiModelProperty("频道随机码:阿里api的-Nonce")
    private String nonce;
    @ApiModelProperty("频道时间戳:阿里api的-Timestamp")
    private Long timestamp;
    @ApiModelProperty("加入频道Token:阿里api的-token")
    private String token;
    @ApiModelProperty("应用ID:阿里api的-AppID")
    private String appId;
    @ApiModelProperty("服务地址:阿里api的-GSLB")
    private List<String> gslb;

}
