package com.yueyang.center.domain.model;

import lombok.Data;

import java.util.List;

/**
 * @program: noah-parent
 * @description: 树形结构
 * @author: qxy
 * @create: 2020-03-19 16:08
 **/
@Data
public class Tree<T> {
    /**
     * 节点列表
     */
    private List<Node<T>> nodes;

    @Data
    public static class Node<T> {

        /**
         * 当前节点的数据
         */
        private T data;

        /**
         * 子节点
         */
        private List<Node<T>> children;
    }
}
