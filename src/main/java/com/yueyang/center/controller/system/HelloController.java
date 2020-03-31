package com.yueyang.center.controller.system;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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


    @PostMapping(value = "/world")
    public String helloWorld() {
        return "Hello World";
    }

}