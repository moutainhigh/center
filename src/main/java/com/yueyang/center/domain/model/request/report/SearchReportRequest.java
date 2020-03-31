package com.yueyang.center.domain.model.request.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: live
 * @description: 相关报道搜索条件
 * @author: qinxiangyang
 * @create: 2020-03-19 22:54
 **/
@Data
public class SearchReportRequest {


    @ApiModelProperty(value = "报道状态 1草稿2待审3发布4退回")
    private Integer status;

    @ApiModelProperty(value = "下线/上线  1：下线，2：上线")
    private Integer offline;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "现场Id")
    private Long liveId;


    /**
     * 类型 1.直播2.追踪报道
     */
    @ApiModelProperty(value = "类型 1.直播2.追踪报道")
    private Integer type;

}