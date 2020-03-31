package com.yueyang.center.controller.system;

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
        return "Hello World" + "," + name;
    }

}