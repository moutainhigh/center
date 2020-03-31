package com.yueyang.center.domain.model.request.Live;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

/**
 * 起始时间,结束事件,审核状态,现场状态,现场类型,租户id,标题,关键词
 *
 * @author yangyongping
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "LivePageRequest", description = "现场分页查询")
@AllArgsConstructor
public class LivePageRequest {
    @ApiModelProperty("开始时间")
    private String startTimee;

    @ApiModelProperty("结束时间")
    private String endTimee;

    /**
     * 状态 1.预告2.直播中3.回顾
     */
    @ApiModelProperty(value = "状态 1.预告2.直播中3.回顾")
    private Integer state;


    /**
     * 类型 1.报道，2.外链现场
     */
    @ApiModelProperty(value = "类型  1.报道现场，2.外链现场")
    private Integer type;

    /**
     * 现场状态 0草稿1待审2发布
     */

    @ApiModelProperty(value = "成品现场，待签现场使用，现场状态  1草稿，2待审，3成品，4退回，5删除")
    private Integer status;


    @ApiModelProperty(value = "我的现场使用", hidden = true)
    private Long creator;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "关键词")
    private String keywords;

    @ApiModelProperty(value = "1：我的现场，2：待签现场，3：成品现场")
    @Range(min = 1, max = 3, message = "现场接口类型范围1-3")
    private Integer interfaceType;

    @ApiModelProperty(value = "租户id", hidden = true)
    private Long tenantId;

}
