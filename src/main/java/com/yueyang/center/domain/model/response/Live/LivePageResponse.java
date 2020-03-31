package com.yueyang.center.domain.model.response.Live;

import com.yueyang.center.domain.model.request.Live.NewsAuthorRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author yangyongping
 */
@Data
public class LivePageResponse {
    /**
     * id
     */
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
    private String keywords;

    /**
     * 署名
     */
    @ApiModelProperty(value = "署名")
    private String sign;

    /**
     * 类型 1.普通现场2.互动现场3.外链现场
     */
    @ApiModelProperty(value = "类型 1.报道现场，2直播现场")
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
    @Length(max = 1024, message = "封面图长度不能超过1024")

    private String coverImage;

    /**
     * 分享图
     */
    @ApiModelProperty(value = "分享图")
    @Length(max = 1024, message = "分享图长度不能超过1024")

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
     * 现场状态 0草稿1待审2发布
     */
    @ApiModelProperty(value = "现场状态  1草稿，2待审，3成品，4退回，5删除")
    private Integer status;

    @ApiModelProperty(value = " 评论配置，1：先审后发，2：先发后审，3，禁止评论")
    private Integer commentConfig;

    /**
     * 标题
     */
    @ApiModelProperty(value = " 标题")
    private String title;


    /**
     *
     */
    @ApiModelProperty(value = " 上线/下线  1，上线，2下线")
    private Integer offline;
}
