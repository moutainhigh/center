package com.yueyang.center.controller.system;

import com.yueyang.center.service.ISmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: center
 * @description:
 * @author: qinxiangyang
 * @create: 2020-04-01 11:36
 **/
@Api(tags = "短信")
@RestController
@RequestMapping("/sms")
@Slf4j
public class SmsController {
    @Autowired
    private ISmsService smsService;

    @ApiOperation(value = "短信")
    @PostMapping(value = "/sendSms")
    public Boolean sendSms(@RequestParam String phone, @RequestParam String code) {

        return smsService.sendSms(phone, code);
    }
}