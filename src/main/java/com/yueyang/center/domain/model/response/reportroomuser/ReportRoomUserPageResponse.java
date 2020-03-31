package com.yueyang.center.domain.model.response.reportroomuser;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xwzhou
 * @date 2020-03-28 16:04
 */
@Data
public class ReportRoomUserPageResponse implements Serializable{
    private static final long serialVersionUID = -6982567618988951578L;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Long userId;

    /**
     *
     */
    @ApiModelProperty("头像")
    private String icon;
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
     * 真实姓名
     */
    @ApiModelProperty("真实姓名")
    private String realName;

}
