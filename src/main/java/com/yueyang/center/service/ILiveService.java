package com.yueyang.center.service;


import com.yueyang.center.domain.bo.*;
import com.yueyang.center.domain.bo.report.AppLiveBO;
import com.yueyang.center.domain.entity.Live;

import java.util.List;

/**
 * <p>
 * 业务接口
 * 现场 现场管理
 * </p>
 *
 * @author yyp
 * @date 2020-03-18
 */
public interface ILiveService {
    Long insert(Live live);

    Live findById(Long id);

    Boolean update(Live live);


    List<Live> list(LivePageBO livePageRequest);

    Boolean offline(OfflineBO request);

    List<Live> sortList(SearchLiveSortBO searchLiveSortRequest);

    Boolean oneKeyPublish(OneKeyPublishBO request);

    Boolean delete(IdBO idBO);

    List<Live> checkTitle(CheckTitleBO checkTitleBO);

    List<Live> queryList(AppLiveBO liveBO);
}
