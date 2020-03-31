package com.yueyang.center.exception;


import com.yueyang.center.enums.ErrorCode;
import com.yueyang.center.enums.IErrorCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class NoahException extends RuntimeException {
    /** 异常码 */
    private Long errorCode = ErrorCode.UNDEFINED.getCode();
    /** 对用户友好的错误信息 */
    private String msg;

    public NoahException(Long errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.msg = message;
    }

    public NoahException(String message) {
        super(message);
        this.msg = message;
    }

    public NoahException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode.getCode();
        this.msg = errorCode.getMessage();
    }


}