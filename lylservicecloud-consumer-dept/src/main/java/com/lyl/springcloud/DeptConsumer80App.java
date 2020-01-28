package com.lyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.lyl.myrule.MySelfRule;

@EnableEurekaClient
@SpringBootApplication
//在启动该微服务的时候就能加载我们自定义的Ribbon配置类，从而使配置生效
//MySelfRule需要在springcloud包外，因为SpringBootApplication注解对该包内配置起作用
@RibbonClient(name="STUDY-SPRINGCLOUD-DEPT", configuration = MySelfRule.class)
public class DeptConsumer80App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80App.class,args);
    }
}