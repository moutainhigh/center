package com.yueyang.center.domain.model.request.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: live
 * @description: 待签报道
 * @author: qinxiangyang
 * @create: 2020-03-27 11:31
 **/
@Data
public class SearchPendReportRequest {

    @ApiModelProperty("开始时间")
    Date startTime;

    @ApiModelProperty("结束时间")
    Date endTime;

    /**
     * 类型 1.直播2.追踪报道
     */
    @ApiModelProperty(value = "类型 1.直播2.追踪报道")
    private Integer type;


    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词")
    private String keywords;


}