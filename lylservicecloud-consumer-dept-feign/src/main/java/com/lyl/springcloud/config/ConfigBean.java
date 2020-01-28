package com.lyl.springcloud.config;

import java.util.Random;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

//假如配置
@Configuration
public class ConfigBean { //相当于applicationContext.xml
	
	//网络请求组件
	@Bean
	@LoadBalanced  //Ribbon客户端注解， 负载均衡的工具  默认轮询
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	@Bean
	public IRule myRule(){
		/*return new RandomRule();*/   //用我们重新选择的随机算法去替代轮询
		return new RetryRule();        //先按照轮询策略获取服务，如果获取服务失败会在指定的时间内重试，获取可用的服务
	}
}
