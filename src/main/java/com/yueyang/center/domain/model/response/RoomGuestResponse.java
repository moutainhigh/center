package com.yueyang.center.domain.model.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @program: gusteau-live
 * @description: 封装嘉宾的一些信息
 * @author: whl
 * @create: 2020-03-31 14:52
 **/
@Data
@Accessors(chain = true)
public class RoomGuestResponse implements Serializable {
    /**
     * 用户key
     **/
    @ApiModelProperty("用户key")
    private String userId;
    /**
     * 音频状态
     **/
    @ApiModelProperty("音频状态")
    private boolean audio;
    /**
     * 视频状态
     */
    @ApiModelProperty("视频状态")
    private boolean video;
    /**
     * 加入大屏状态
     **/
    @ApiModelProperty("加入大屏状态")
    private boolean joined;
    /**
     * 进入房间状态
     **/
    @ApiModelProperty("进入房间状态")
    private boolean entered;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String icon;

    /**
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String realName;

    /**
     * 机构
     */
    @ApiModelProperty("机构")
    private String organization;

    /**
     * 职位
     */
    @ApiModelProperty("职位")
    private String position;

    /**
     * 用户类型 0记者 1专家 2订阅号 3 企业用户 4 普通用户
     */
    @ApiModelProperty("用户类型 0记者 1专家 2订阅号 3 企业用户 4 普通用户 5 主持人")
    private Integer userType;

    /**
     * 昵称
     */
    @ApiModelProperty("昵称")
    private String nickName;
}
