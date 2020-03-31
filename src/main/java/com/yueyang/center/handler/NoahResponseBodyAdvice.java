package com.yueyang.center.handler;

import com.yueyang.center.domain.model.ResultModel;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Collections;
import java.util.List;


@ControllerAdvice
@Component
public class NoahResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    private static final Object EMPTY_OBJ = new Object();
    private static final List EMPTY_LIST = Collections.emptyList();

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {

        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(aClass);
    }


    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        String uri = ((ServletServerHttpRequest) serverHttpRequest).getServletRequest().getRequestURI();
        if (uri.matches("(.*)/swagger-resources") || uri.matches("(.*)/v2/api-docs")) {
            return body;
        }

        if (body == null) {
            return ResultModel.succ(body);
        }

        if (body instanceof ResultModel) {
            return body;
        } else {
            return ResultModel.succ(body);
        }
    }
}
