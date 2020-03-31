package com.yueyang.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(value = "com.yueyang.center.domain.mapper")
@SpringBootApplication(scanBasePackages = "com.yueyang.center")
@ComponentScan(basePackages = "com.yueyang")
@ServletComponentScan
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

}
