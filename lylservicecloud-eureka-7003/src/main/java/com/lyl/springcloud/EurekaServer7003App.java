package com.lyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author GongXings
 * @createTime 30 18:04
 * @description
 */
@SpringBootApplication
/**
 * 启用eureka服务,接收其他服务注册
 */
@EnableEurekaServer
public class EurekaServer7003App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003App.class,args);
    }
}