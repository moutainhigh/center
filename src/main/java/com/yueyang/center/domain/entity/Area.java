package com.yueyang.center.domain.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 区域表 
 * </p>
 *
 * @author xwzhou
 * @since 2020-03-27
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "area", description = "区域表")
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 父类code
     */
    private Long parentId;

    /**
     * 名称
     */
    private String name;


}
