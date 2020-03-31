package com.yueyang.center.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 实体类
 * 现场-报道表
 * </p>
 *
 * @author yyp
 * @since 2020-03-19
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "LiveReport", description = "现场-报道表 ")
@AllArgsConstructor
public class LiveReport implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 现场id
     */
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 现场id
     */
    @ApiModelProperty(value = "现场id")
    private Long liveId;

    /**
     * 报道id
     */
    @ApiModelProperty(value = "报道id")
    private Long reportId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = " 创建时间")
    private Date createTime;

    /**
     * 修改时间
     */
    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    /**
     * 现场id
     */
    @ApiModelProperty(value = "租户Id")
    private Long tenantId;

}

