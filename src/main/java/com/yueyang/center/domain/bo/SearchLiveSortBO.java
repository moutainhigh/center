package com.yueyang.center.domain.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 16:49
 **/
@Data
public class SearchLiveSortBO {
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