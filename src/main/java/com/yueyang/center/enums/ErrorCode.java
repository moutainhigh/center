package com.yueyang.center.enums;

public enum ErrorCode implements IErrorCode {
    /**
     * 成功
     */
    SUCCESS(0L, "成功"),
    /**
     * 失败
     */
    FAIL(1L, "失败"),
    /**
     * 参数异常
     */
    PARAM_ERROR(2L, "参数异常"),
    /**
     * 服务连接异常
     */
    CONNECTION_ERROR(3L, "服务连接异常"),
    /**
     * 未明确定义名称异常
     */
    UNDEFINED(10001, "未明确定义名称异常"),
    ;


    private long code;
    private String message;

    ErrorCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
