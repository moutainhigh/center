package com.yueyang.center.service;

/**
 * @program: gusteau-live
 * @description: 发送短信的接口
 * @author: wxy
 * @create: 2020-03-31 11:33
 **/
public interface ISmsService {
    boolean sendSms(String phone, String code);
}
