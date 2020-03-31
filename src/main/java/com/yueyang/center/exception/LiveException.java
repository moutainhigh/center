package com.yueyang.center.exception;


import com.yueyang.center.enums.IErrorCode;

public class LiveException extends NoahException {

    public LiveException(Long errorCode, String message) {
        super(errorCode, message);
    }

    public LiveException(String message) {
        super(message);
    }

    public LiveException(IErrorCode errorCode) {
        super(errorCode.getCode(), errorCode.getMessage());
    }

}