package com.yueyang.center.domain.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: gusteau-live
 * @description:
 * @author: whl
 * @create: 2020-03-31 11:32
 **/
@Data
public class RoomGuestListResponse {
    @ApiModelProperty("旁路直播视频流地址")
    private String streamURL;

    @ApiModelProperty("房间号")
    private Long roomId;

    @ApiModelProperty("任务Id")
    private String taskId;

    @ApiModelProperty("房间开启状态")
    private boolean isOpen;
    @ApiModelProperty("嘉宾和主持人")
    List<RoomGuestResponse> guestList;
}
