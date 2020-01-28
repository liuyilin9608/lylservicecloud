package com.lyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //开启config服务端
public class Config3344App {
    public static void main(String[] args) {
        SpringApplication.run(Config3344App.class,args);
    }
}