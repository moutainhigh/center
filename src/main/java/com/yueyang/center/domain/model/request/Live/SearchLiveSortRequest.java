package com.yueyang.center.domain.model.request.Live;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: live
 * @description: 排序列表参数
 * @author: qinxiangyang
 * @create: 2020-03-27 09:26
 **/
@Data
public class SearchLiveSortRequest {

    @ApiModelProperty("开始时间")
    Date startTime;

    @ApiModelProperty("结束时间")
    Date endTime;

    /**
     * 现场状态 0草稿1待审2发布
     */

    @ApiModelProperty(value = "成品现场，待签现场使用，现场状态  1草稿，2待审，3成品，4退回，5删除", hidden = true)
    private Integer status;


    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "关键词")
    private String keywords;

    @ApiModelProperty(value = "租户id", hidden = true)
    private Long tenantId;

}