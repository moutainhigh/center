package com.yueyang.center.domain.bo.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @program: gusteau-live
 * @description: 客户端现场分页参数
 * @author: wxy
 * @create: 2020-03-30 19:58
 **/
@Data
public class AppLiveBO {
    @ApiModelProperty(value = "现场状态 0草稿1待审2发布", hidden = true)
    private Integer status;

    @ApiModelProperty(value = "上线/下线 1:上线，2：下线", hidden = true)
    private Integer offline;

}
