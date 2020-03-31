package com.yueyang.center.domain.model.response.Live;

import com.yueyang.center.domain.model.request.Live.NewsAuthorRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author yangyongping
 */
@Data
public class LiveResponse {

    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    private Date publishTime;

    /**
     * 新闻作者 允许十个
     */
    @ApiModelProperty(value = "新闻作者 允许十个")
    private List<NewsAuthorRequest> newsAuthors;

    /**
     * 关键词
     */
    @ApiModelProperty(value = "关键词")
    private String keywords;

    /**
     * 署名
     */
    @ApiModelProperty(value = "署名")
    private String sign;

    /**
     * 类型 1.普通现场2.互动现场3.外链现场
     */
    @ApiModelProperty(value = "类型  1.报道现场，2.外链现场")
    private Integer type;

    /**
     * 状态 1.预告2.直播中3.回顾
     */
    @ApiModelProperty(value = "状态 1.预告2.直播中3.回顾")
    private Integer state;

    /**
     * 封面图
     */
    @ApiModelProperty(value = "封面图")
    private String coverImage;

    /**
     * 分享图
     */
    @ApiModelProperty(value = "分享图")
    private String shareImage;

    /**
     * 现场简介
     */
    @ApiModelProperty(value = "现场简介")
    private String summary;

    /**
     * 外链 外链稿件url
     */
    @ApiModelProperty(value = "外链 外链稿件url")
    private String url;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private BigDecimal longitude;

    /**
     * 维度
     */
    @ApiModelProperty(value = "维度")
    private BigDecimal latitude;

    /**
     * 开启报名审核
     */
    @ApiModelProperty(value = "开启报名审核  1：开启，0：关闭")
    private Integer applyReview;

    /**
     * 默认报道排序,1，时间倒序，2，时间正序
     */
    @ApiModelProperty(value = "默认报道排序,1，时间倒序，2，时间正序")
    private Integer defaultReportSort;

    /**
     * 评论配置，1：先审后发，2：先发后审，3，禁止评论
     */
    @ApiModelProperty(value = " 评论配置，1：先审后发，2：先发后审，3，禁止评论")
    private Integer commentConfig;

    /**
     * 上线/下线  上线 ：1，下线：2
     */
    @ApiModelProperty(value = "上线/下线  上线 ：1，下线：2")
    private Integer offline;

    /**
     * 现场状态 0草稿1待审2发布
     */
    @ApiModelProperty(value = "现场状态 1草稿，2待审，3成品，4退回，5删除")
    private Integer status;


    @ApiModelProperty(value = "现场标题")
    private String title;


    @ApiModelProperty(value = "退回原因")
    private String reason;

}
