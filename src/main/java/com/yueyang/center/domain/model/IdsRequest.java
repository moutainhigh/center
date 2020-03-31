package com.yueyang.center.domain.model;

/**
 * @program: center
 * @description:
 * @author: qinxiangyang
 * @create: 2020-03-31 21:08
 **/

import lombok.Data;

import java.util.List;

/**
 * 通用ids请求参数实体
 */
@Data
public class IdsRequest {

    private List<Long> ids;
}
