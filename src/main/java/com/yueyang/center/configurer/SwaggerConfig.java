package com.yueyang.center.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: usercenter
 * @author: wxy
 * @create: 2020-03-17 15:16
 * @desc:
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket liveApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("live")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yueyang.center.controller.live"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket systemApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("system")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yueyang.center.controller.system"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger-bootstrap-ui resultFul APIs")
                .description("swagger-bootstrap-ui")
                .termsOfServiceUrl("http://localhost:9001/")
                .version("1.0")
                .build();
    }
}
