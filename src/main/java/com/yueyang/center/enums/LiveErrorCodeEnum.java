package com.yueyang.center.enums;

import lombok.Getter;

/**
 * @program: usercenter
 * @description: 用户中心错误码
 * @author: wxy
 * @create: 2020-03-18 17:46
 **/
@Getter
public enum LiveErrorCodeEnum implements IErrorCode {


    /**
     * 公共部分错误码 10002 --20000
     **/
    ID_NULL(10002, "id为空"),
    INSERT_ERR(10003, "插入失败"),
    OBJECT_IS_NULL(10004, "传入参数为空"),

    /**
     * 现场错误码 20001 --30000
     **/
    LIVE_NOT_EXIT(20001, "现场不存在，请刷新页面"),
    LIVE_LIST_TYPE_ISNULL(20002, "现场列表接口类型为空"),
    LIVE_TITLE_ISNULL(20003, "请输入现场标题"),
    LIVE_TITLE_EXIT(20004, "现场标题重复，请重新输入标题"),

    /**
     * 报道错误码 30001 --40000
     **/
    LIVE_REPORT_INSERT_FAIL(30001, "现场报道关联表插入失败"),
    REPORT_NOT_EXIT(30002, "报道不存在，请刷新页面"),
    LIVEID_IS_NULL(30003, "查询传入liveId为空"),
    REPORT_TITLE_ISNULL(30004, "请输入报道标题"),
    REPORT_TITLE_EXIT(30005, "报道标题重复，请重新输入标题"),


    /**
     * 用户模块 40001 --50000
     */
    USER_NOT_EXIT(40001, "用户不存在"),

    /**
     * 报导模块 40001 --50000
     */
    REPORTROOMUSER_NOT_EXIT(50001, "邀请嘉宾不存在"),
    REPORTROOMUSER_BEYOND_MAXIMUM(50002, "最多可加入15个嘉宾"),
    ;


    private final long code;
    private final String message;

    private LiveErrorCodeEnum(long code, String message) {
        this.code = code;
        this.message = message;
    }
}
