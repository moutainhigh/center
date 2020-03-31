package com.yueyang.center.controller.live;

import com.yueyang.center.biz.ILiveBiz;
import com.yueyang.center.domain.model.IdRequest;
import com.yueyang.center.domain.model.PageResult;
import com.yueyang.center.domain.model.PageWrapper;
import com.yueyang.center.domain.model.request.Live.*;
import com.yueyang.center.domain.model.response.Live.LivePageResponse;
import com.yueyang.center.domain.model.response.Live.LiveResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * <p>
 * 前端控制器
 * 现场 现场管理
 * </p>
 *
 * @author yyp
 * @date 2020-03-18
 */
@Slf4j
@Validated
@RestController
@RequestMapping("/live")
@Api(value = "Live", tags = "现场 现场管理")
public class LiveController {
    @Autowired
    private ILiveBiz liveBiz;

    @ApiOperation(value = "现场列表,我的现场/成品现场/待签现场", notes = "现场列表")
    @PostMapping(value = "/list")
    public PageResult<LivePageResponse> list(@RequestBody @Valid PageWrapper<LivePageRequest> request) {
        return liveBiz.list(request);
    }

    @ApiOperation(value = "现场详情", notes = "现场详情")
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    public LiveResponse detail(@RequestBody @Valid IdRequest request) {
        return liveBiz.detail(request);
    }


    @ApiOperation(value = "创建", notes = "创建")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Long create(@RequestBody @Valid LiveRequest request) {
        return liveBiz.create(request);
    }


    @ApiOperation(value = "更新", notes = "更新")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean update(@RequestBody @Valid LiveRequest request) {
        return liveBiz.update(request);
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Boolean delete(@RequestBody @Valid IdRequest request) {
        return liveBiz.delete(request);
    }

    @ApiOperation(value = "一键成品", notes = "一键成品")
    @RequestMapping(value = "/one-key-publish", method = RequestMethod.POST)
    public Boolean oneKeyPublish(@RequestBody @Valid IdRequest request) {
        return liveBiz.oneKeyPublish(request);
    }

    @ApiOperation(value = "下线/上线", notes = "一键成品")
    @RequestMapping(value = "/offline", method = RequestMethod.POST)
    public Boolean offline(@RequestBody @Valid OfflineRequest request) {
        return liveBiz.offline(request);
    }

    @ApiOperation(value = "审核", notes = "审核")
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public Boolean review(@RequestBody @Valid IdRequest request) {
        return liveBiz.review(request);
    }

    @ApiOperation(value = "提交审核", notes = "审核")
    @RequestMapping(value = "/submit-review", method = RequestMethod.POST)
    public Boolean submitReview(@RequestBody @Valid IdRequest request) {
        return liveBiz.submitReview(request);
    }

    @ApiOperation(value = "退回", notes = "退回")
    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public Boolean withdraw(@RequestBody @Valid WithdrawRequest request) {
        return liveBiz.withdraw(request);
    }

    @ApiOperation(value = "排序列表", notes = "现场列表")
    @PostMapping(value = "/sort-list")
    public PageResult<LivePageResponse> sortList(@RequestBody @Valid PageWrapper<SearchLiveSortRequest> request) {
        return liveBiz.sortList(request);
    }


    @ApiOperation(value = "现场-排序", notes = "用于原型中:报道")
    @PostMapping(value = "/sort")
    public Boolean sort(@Valid @RequestBody SortRequest sortRequest) {
        return liveBiz.sort(sortRequest);
    }

}
