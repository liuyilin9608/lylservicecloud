package com.lyl.springcloud.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LYL
 * @createTime  19:45
 * @description 从github上读取的yml文件的信息
 * @Value读取配置文件信息
 * ！！！BUG Value注入不进去值
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.server-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){

        System.out.println("applicationName:"+this.applicationName
                +"eurekaServers:"+this.eurekaServers
                +"port:"+this.port);
        return "applicationName:"+this.applicationName
                +"eurekaServers:"+this.eurekaServers
                +"port:"+this.port;
    }
}