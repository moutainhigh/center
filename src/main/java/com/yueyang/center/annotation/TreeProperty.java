package com.yueyang.center.annotation;



import com.yueyang.center.enums.TreePropertyEnum;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TreeProperty {


    TreePropertyEnum value() default TreePropertyEnum.CHILDREN;

}
