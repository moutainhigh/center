package com.yueyang.center.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @program: center
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-31 21:05
 **/
@Data
@NoArgsConstructor
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**总记录数**/
    private long total;
    /**每页记录数**/
    private long size;
    /**总页数**/
    private long pages;
    /**当前页数**/
    private long current;
    /**列表数据**/
    private List<T> records;

    /**
     * 分页
     * @param records        列表数据
     * @param total  总记录数
     * @param size    每页记录数
     * @param current    当前页数
     */
    public PageResult(List<T> records, long total, long size, long current) {
        this.records = records;
        this.total = total;
        this.size = size;
        this.current = current;
        this.pages = calculatePages(total, size);
    }

    private long calculatePages(long total, long size) {
        if (size == 0L) {
            return 0L;
        } else {
            long pages = total / size;
            if (total % size != 0L) {
                ++pages;
            }

            return pages;
        }
    }
}