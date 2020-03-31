package com.yueyang.center.service.impl;


import com.yueyang.center.domain.bo.*;
import com.yueyang.center.domain.bo.report.AppLiveBO;
import com.yueyang.center.domain.entity.Live;
import com.yueyang.center.domain.mapper.ILiveDAO;
import com.yueyang.center.service.ILiveService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 业务实现类
 * 现场 现场管理
 * </p>
 *
 * @author yyp
 * @date 2020-03-18
 */
@Slf4j
@Service
public class ILiveServiceImpl implements ILiveService {

    @Autowired
    private ILiveDAO liveDAO;

    @Override
    public Live findById(Long id) {
        return liveDAO.findById(id);
    }

    @Override
    public Long insert(Live live) {
        return liveDAO.insert(live) > 0 ? live.getId() : 0L;
    }

    @Override
    public Boolean update(Live live) {
        return liveDAO.update(live);
    }


    @Override
    public List<Live> list(LivePageBO livePageRequest) {
        return liveDAO.list(livePageRequest);
    }

    @Override
    public Boolean offline(OfflineBO request) {
        return liveDAO.offline(request);
    }

    @Override
    public List<Live> sortList(SearchLiveSortBO searchLiveSortRequest) {
        return liveDAO.sortList(searchLiveSortRequest);
    }

    @Override
    public Boolean oneKeyPublish(OneKeyPublishBO request) {
        return liveDAO.oneKeyPublish(request);
    }

    @Override
    public Boolean delete(IdBO idBO) {
        return liveDAO.delete(idBO);
    }

    @Override
    public List<Live> checkTitle(CheckTitleBO checkTitleBO) {
        return liveDAO.checkTitle(checkTitleBO);
    }

    @Override
    public List<Live> queryList(AppLiveBO liveBO) {
        return liveDAO.queryList(liveBO);
    }

}
