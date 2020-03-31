package com.yueyang.center.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 现场 现场管理
 */
@Data
public class Live implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 创建人
     */
    private Long creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private Long modifier;

    /**
     * 更新时间
     */
    private Date modifyTime;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 发布时间
     */
    private Date publishTime;

    /**
     * 现场作者 允许十个
     */
    private String newsAuthor;

    /**
     * 关键词
     */
    private String keywords;

    /**
     * 作者署名
     */
    private String sign;

    /**
     * 类型 1.报道现场2.外链现场
     */
    private Integer type;

    /**
     * 状态 1.预告2.直播中3.回放
     */
    private Integer state;

    /**
     * 封面图
     */
    private String coverImage;

    /**
     * 分享图
     */
    private String shareImage;

    /**
     * 现场简介
     */
    private String summary;

    /**
     * 外链 外链稿件url
     */
    private String url;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 维度
     */
    private BigDecimal latitude;

    /**
     * 现场状态1草稿，2待审，3成品，4退回，5删除，
     */
    private Integer status;

    /**
     * 标题
     */
    private String title;

    /**
     * 开启报名审核
     */
    private Integer applyReview;

    /**
     * 默认报道排序,1，时间倒序，2，时间正序
     */
    private Integer defaultReportSort;

    /**
     * 评论配置，1：先审后发，2：先发后审，3，禁止评论
     */
    private Integer commentConfig;

    /**
     * 上线/下线  上线 ：1，下线：2
     */
    private Integer offline;

    /**
     * 排序值
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;
}