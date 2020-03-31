package com.yueyang.center.domain.model.request.comment;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @program: gusteau-live
 * @description:
 * @author: whl
 * @create: 2020-03-26 14:06
 **/
@Data
public class CommentApprovalRequest {
    @ApiModelProperty("评论主键id")
    private List<Long> ids;
    @ApiModelProperty("审批情况 0 待审 1审核启用 2审核禁用 -1是删除")
    private Integer status;
}
