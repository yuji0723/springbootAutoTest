package com.jin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2//最基础用法，开启swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("pig的项目1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jin.controller"))// 指定扫描的Controller包
                .build();
    }



    private ApiInfo apiInfo(){
        Contact contact = new Contact("大力pig的博客","https://blog.csdn.net/m0_53753920?spm=1011.2266.3001.5343", "");
        return new ApiInfo(
                "大力pig的swagger文档",
                "在小的帆船也能远航",
                "1.0",
                "https://blog.csdn.net/m0_53753920?spm=1011.2266.3001.5343",
                contact,
                "",
                "",
                new ArrayList<>()
        );
    }
}

