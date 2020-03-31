package com.yueyang.center.domain.bo;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: live
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-27 18:49
 **/
@Data
public class CommonBO {

    /**
     * id 集合
     */
    private List<Long> ids;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 修改者
     */
    private Long modifier;

    /**
     * 修改者
     */
    private Date  modifyTime;
}