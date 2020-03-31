package com.yueyang.center.domain.model.request.Live;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author yangyongping
 * 创建现场参数:标题,发布时间,直播作者[],
 * 作者署名,现场状态,关键词,直播类型，
 * 直播流地址，预告视频类型,视频URL，
 * 回放视频类型,回放视频URL，封面图片URL，
 * 分享图片URL，直播简介,评论配置,
 * 经度，维度，状态,退回理由
 */
@ApiModel
@Data
public class LiveRequest {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private Long id;


    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    @NotNull(message = "发布时间不能为空")
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
    @Length(max = 1024, message = "关键词长度不能超过1024")
    private String keywords;

    /**
     * 署名
     */
    @ApiModelProperty(value = "署名")
    @Length(max = 10, message = "署名长度不能超过10")
    private String sign;

    /**
     * 类型 1.报道，2.外链现场
     */
    @ApiModelProperty(value = "类型  1.报道，2.外链现场")
    @NotNull(message = "类型不能为空")
    @Range(min = 1, max = 2, message = "现场类型不能为空")
    private Integer type;

    /**
     * 状态 1.预告2.直播中3.回顾
     */
    @ApiModelProperty(value = "状态 1.预告2.直播中3.回顾")
    @NotNull(message = "现场状态不能为空")
    private Integer state;

    /**
     * 封面图
     */
    @ApiModelProperty(value = "封面图")
    @NotNull(message = "封面图片不能为空")
    private String coverImage;

    /**
     * 分享图
     */
    @ApiModelProperty(value = "分享图")
    @NotNull(message = "分享图片不能为空")
    private String shareImage;

    /**
     * 现场简介
     */
    @ApiModelProperty(value = "现场简介")
    @Length(max = 200, message = "现场简介长度不能超过200")
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
     * 现场状态 0草稿1待审2发布
     */
    @ApiModelProperty(value = "现场状态  1草稿，2待审，3成品，4退回，5删除")
    @NotNull(message = "现场状态保存状态不能为空")
    private Integer status;


    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 开启报名审核
     */
    @ApiModelProperty(value = "开启报名审核")
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
}
