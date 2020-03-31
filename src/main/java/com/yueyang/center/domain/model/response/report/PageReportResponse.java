package com.yueyang.center.domain.model.response.report;

import com.yueyang.center.domain.model.request.Live.NewsAuthorRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @program: live
 * @description: 报道列表数据
 * @author: qinxiangyang
 * @create: 2020-03-27 13:04
 **/
@Data
public class PageReportResponse {


    /**
     * 报道Id
     */
    private Long id;

    @ApiModelProperty("现场Id")
    @NotNull(message = "现场Id不能为空")
    private Long liveId;

    /**
     * 发布时间
     */
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
     * 类型 1.直播2.追踪报道
     */
    @ApiModelProperty(value = "类型 1.直播2.追踪报道")
    private Integer type;

    /**
     * 直播状态 1.预告2.直播中3.回顾
     */
    @ApiModelProperty(value = "直播状态 1.预告2.直播中3.回顾")
    private Integer state;

    /**
     * 直播流地址
     */
    @ApiModelProperty(value = "直播流地址")
    private String stream;

    /**
     * 预告类型，1:无，2：外链，3：上传
     */
    @ApiModelProperty(value = "预告类型，1:无，2：外链，3：上传")
    private String noticeType;

    /**
     * 预告URL
     */
    @ApiModelProperty(value = "预告URL")
    private String noticeUrl;

    /**
     * 回放类型,1:无，2：外链，3：上传
     */
    @ApiModelProperty(value = "回放类型,1:无，2：外链，3：上传")
    private String playbackType;

    /**
     * 回放URL
     */
    @ApiModelProperty(value = "回放URL")
    private String playbackUrl;

    /**
     * 封面图
     */
    @ApiModelProperty(value = "封面图")
    private List<String> coverImages;


    /**
     * 外链 外链稿件url
     */
    @ApiModelProperty(value = "外链 外链稿件url")
    private String url;



    /**
     * 报道状态 1草稿2待审3发布，4，退回，5删除
     */
    @ApiModelProperty(value = "报道状态 1草稿2待审3发布，4，退回，5删除")
    private Integer status;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 报道类型 1.图文2视频3音频
     */
    @ApiModelProperty(value = "报道类型 1.图文2视频3音频")
    private Integer reportType;




}