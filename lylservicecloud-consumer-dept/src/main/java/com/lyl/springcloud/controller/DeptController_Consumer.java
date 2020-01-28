package com.lyl.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lyl.springcloud.entities.Dept;

@RestController
public class DeptController_Consumer {

	/*private static final String REST_URL_PREFIX = "http://localhost:8001";*/
	private static final String REST_URL_PREFIX = "http://STUDY-SPRINGCLOUD-DEPT";
	// 便捷访问远程Http服务的方法
	@Autowired
	private RestTemplate restTemplate;

	/*
	 * (url,restMap,ResponseBean.class) 三个方法分别代表：
	 * REST请求地址，请求参数，HTTP响应转换被转换成的对象类型
	 */
	@RequestMapping(value = "/consumer/dept/add")
	public boolean add(Dept dept) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept,
				Boolean.class);
	}

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id) {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id,
				Dept.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list() {
		return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list",
				List.class);
	}
}
