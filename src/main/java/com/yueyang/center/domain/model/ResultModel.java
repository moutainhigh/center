package com.yueyang.center.domain.model;

import com.yueyang.center.enums.ErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


import java.io.Serializable;

@Data
public class ResultModel<T> implements Serializable {

    /**
     * 返回错误码
     */
    @ApiModelProperty(value = "返回错误码数")
    private long code = ErrorCode.SUCCESS.getCode();

    /**
     * 返回错误信息
     */
    @ApiModelProperty(value = "返回错误信息")
    private String message = ErrorCode.SUCCESS.getMessage();

    /**
     * 数据
     */
    @ApiModelProperty(value = "数据")
    private T data;

    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();


    /**
     * 是否加密
     **/
    @ApiModelProperty(value = "是否加密")
    private boolean encryption = false;

    /**
     * 加密数据
     **/
    @ApiModelProperty(value = "加密数据")
    private String ciphertext;


    public ResultModel(long code, T data, String message) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultModel(long code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ResultModel(ErrorCode errorCode) {
        super();
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public ResultModel() {
    }

    public ResultModel(T data) {
        this.data = data;
    }

    public static <T> ResultModel<T> error(ErrorCode errorCode) {
        return new ResultModel<>(errorCode);
    }

    public static <T> ResultModel<T> error(long errorCode, String msg) {
        return new ResultModel<>(errorCode, msg);
    }

    public static <T> ResultModel<T> error(long errorCode, String msg, T data) {
        return new ResultModel<>(errorCode, data, msg);
    }

    public static <T> ResultModel<T> fail() {
        return new ResultModel<>(ErrorCode.FAIL);
    }

    public static <T> ResultModel<T> succ() {
        return new ResultModel<>(ErrorCode.SUCCESS);
    }

    public static <T> ResultModel<T> succ(T data) {
        return new ResultModel<>(data);
    }
}
