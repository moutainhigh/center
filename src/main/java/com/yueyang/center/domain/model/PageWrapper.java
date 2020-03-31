package com.yueyang.center.domain.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: center
 * @description: 分页参数包装类
 * @author: qinxiangyang
 * @create: 2020-03-31 21:08
 **/
@Data
public class PageWrapper<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    private int current;

    /**
     * 每页条数
     */
    private int size;

    /**
     * 查询条件
     */
    private T condition;
}
