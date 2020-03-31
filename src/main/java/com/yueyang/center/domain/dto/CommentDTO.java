package com.yueyang.center.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * @program: gusteau-live
 * @description:
 * @author: whl
 * @create: 2020-03-26 11:20
 **/
@Data
public class CommentDTO {

    private Long id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 用户头像
     */

    private String icon;
    /**
     * 评论内容
     */

    private String content;
    /**
     * 内容标题
     */

    private String title;
    /**
     * 稿件类型 1稿件 2.现场
     */

    private Integer type;


    /**
     * 评论来源
     */

    private String source;


    /**
     * 状态 待审:0，启用:1，禁用:2
     */
    private Long status;
    private Date createTime;
    /**
     * 现场id/稿件id
     */
    private Long relationId;
    /**
     * 用户类型 0记者 1专家 2订阅号 3 企业用户 4 普通用户
     */
    private Integer userType;
}
