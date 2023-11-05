package com.jin;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("com.jin.mapper")
@ComponentScan(basePackages = {"com.jin"})
public class AutoApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoApplication.class, args);
    }
}
