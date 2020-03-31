package com.yueyang.center.exception;


import com.alibaba.fastjson.JSON;

import com.netflix.client.ClientException;
import com.yueyang.center.domain.model.ResultModel;
import com.yueyang.center.enums.ErrorCode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.ServletRequest;
import java.nio.charset.Charset;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoahException.class)
    @ResponseBody
    public ResultModel<Boolean> noahExceptionHandler(NoahException e, ServletRequest request) {
        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
        logger.error("error in \nurl :{} \ncode:{} \nmsg:{} \nparams:{}\n body:{}", ((ContentCachingRequestWrapper) request).getRequestURI(), e.getErrorCode(), e.getMsg(), JSON.toJSONString(request.getParameterMap()), StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding())));
        return ResultModel.error(e.getErrorCode(), e.getMsg());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultModel<Boolean> methodArgumentNotValidHandler(MethodArgumentNotValidException e, ServletRequest request) {
        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
        String message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
        logger.error("error in \nurl :{} \nmsg:{} \nparams:{}\n body:{}", ((ContentCachingRequestWrapper) request).getRequestURI(), message, JSON.toJSONString(request.getParameterMap()), StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding())));
        return ResultModel.error(ErrorCode.FAIL.getCode(), message);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultModel<Boolean> methodArgumentNotValidHandler(MissingServletRequestParameterException e, ServletRequest request) {
        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
        String message = e.getMessage();
        logger.error("error in \nurl :{} \nmsg:{} \nparams:{}\n body:{}", ((ContentCachingRequestWrapper) request).getRequestURI(), message, JSON.toJSONString(request.getParameterMap()), StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding())));
        return ResultModel.error(ErrorCode.FAIL.getCode(), "必填参数为空");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResultModel<Boolean> illegalArgumentHandler(IllegalArgumentException e, ServletRequest request) {
        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
        logger.error("error in \nurl :{} \nmsg:{} \nparams:{}\n body:{}", ((ContentCachingRequestWrapper) request).getRequestURI(), e.getMessage(), JSON.toJSONString(request.getParameterMap()), StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding())));
        return ResultModel.error(ErrorCode.FAIL.getCode(), e.getMessage()
        );
    }

    @ExceptionHandler(ClientException.class)
    @ResponseBody
    public ResultModel<Boolean> clientExceptionHandler(ClientException e, ServletRequest request) {
        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
        logger.error("error in \nurl :{} \nmsg:{} \nparams:{}\n body:{}", ((ContentCachingRequestWrapper) request).getRequestURI(), e.getMessage(), JSON.toJSONString(request.getParameterMap()), StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding())));
        return ResultModel.error(ErrorCode.CONNECTION_ERROR);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultModel<Boolean> exceptionHandler(Exception e, ServletRequest request) {

        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
        logger.error("error in \nurl :{} \nparams:{}\nbody:{}", ((ContentCachingRequestWrapper) request).getRequestURI(), JSON.toJSONString(request.getParameterMap()), StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding())));
        logger.error("程序运行出现异常！", e);
        return ResultModel.error(ErrorCode.UNDEFINED);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultModel<Boolean> exceptionHandler(HttpMessageNotReadableException e, ServletRequest request) {

        ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) request;
        logger.error("error in \nurl :{} \nparams:{}\nbody:{}", ((ContentCachingRequestWrapper) request).getRequestURI(), JSON.toJSONString(request.getParameterMap()), StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding())));
        logger.error("程序运行出现异常！", e);
        return ResultModel.error(ErrorCode.PARAM_ERROR.getCode(), "json格式错误:" + e.getLocalizedMessage());

    }

    public static void main(String[] args) {

        System.out.println("备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字备注有一百五十多的字一".length());
    }

}
