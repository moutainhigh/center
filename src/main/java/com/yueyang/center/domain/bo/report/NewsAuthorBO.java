package com.yueyang.center.domain.bo.report;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author yangyongping
 * 新闻作者
 */
@ApiModel(value = "NewsAuthorRequest", description = "新闻作者")
@Data
@ToString
public class NewsAuthorBO implements Serializable {

    @ApiModelProperty(value = "新闻作者id")
    private Long id;

    @ApiModelProperty(value = "新闻作者名字")
    private String name;
}
