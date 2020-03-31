package com.yueyang.center.domain.bo;

import lombok.Data;

import java.util.List;

/**
 * @program: gusteau-live
 * @description:
 * @author: whl
 * @create: 2020-03-26 13:56
 **/
@Data
public class CommentApprovalBO {
    private List<Long> ids;

    private Integer status;

    private Long modifier;
}
