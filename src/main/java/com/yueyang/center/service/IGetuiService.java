package com.yueyang.center.service;

import com.yueyang.center.domain.model.ResultModel;
import com.yueyang.center.domain.model.request.getui.ToAllParam;
import com.yueyang.center.domain.model.request.getui.ToListParam;
import com.yueyang.center.domain.model.request.getui.ToSingleParam;

/**
 * @program: center
 * @description: 个推接口
 * @author: qinxiangyang
 * @create: 2020-04-01 15:07
 **/
public interface IGetuiService {

    ResultModel<String> toSingle(ToSingleParam param);

    ResultModel<String> toList(ToListParam param);

    ResultModel<String> toAll(ToAllParam param);
}