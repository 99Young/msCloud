package com.yang.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.yang"})
@SpringBootApplication
@MapperScan({"com.yang.springcloud.dao"})
@EnableEurekaClient
public class Payment8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment8001Application.class, args);
    }
}
