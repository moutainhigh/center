package com.yueyang.center.enums;

import java.lang.annotation.*;

/**
 * 标记某个接口或整个类可匿名访问
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Anonymous {
    boolean value() default true;
}
