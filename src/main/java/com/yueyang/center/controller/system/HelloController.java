package com.yueyang.center.controller.system;

import com.yueyang.center.enums.LiveErrorCodeEnum;
import com.yueyang.center.exception.NoahException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: center
 * @description: 你好视界
 * @author: qinxiangyang
 * @create: 2020-03-31 15:02
 **/
@Api(tags = "测试世界")
@RestController
@RequestMapping("/hello")
public class HelloController {


    @ApiModelProperty("你好世界")
    @PostMapping(value = "/world")
    public String helloWorld(@RequestParam String name) {
        throw new NoahException(LiveErrorCodeEnum.INSERT_ERR);

    }

    @ApiModelProperty("测试返回")
    @PostMapping(value = "/testReturn")
    public String testReturn(@RequestParam String name) {
        return  "返回值测试";
    }

}