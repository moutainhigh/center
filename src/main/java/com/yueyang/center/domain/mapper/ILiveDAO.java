package com.yueyang.center.domain.mapper;


import com.yueyang.center.domain.bo.*;
import com.yueyang.center.domain.bo.report.AppLiveBO;
import com.yueyang.center.domain.entity.Live;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * 现场 现场管理
 * </p>
 *
 * @author yyp
 * @date 2020-03-18
 */
public interface ILiveDAO {

    Long insert(Live live);

    Live findById(Long id);

    Boolean update(Live live);

    Boolean delete(IdBO idRequest);


    List<Live> list(LivePageBO livePageRequest);

    List<Live> sortList(SearchLiveSortBO searchLiveSortRequest);

    Boolean offline(OfflineBO request);

    Boolean oneKeyPublish(OneKeyPublishBO request);

    List<Live> checkTitle(CheckTitleBO checkTitleBO);

    List<Live> queryList(AppLiveBO liveBO);

}
