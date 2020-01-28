package com.lyl.springcloud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyl.springcloud.entities.Dept;
import com.lyl.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DeptController {

	// 一旦服务的方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的方法

	@Autowired
	private DeptService service = null;

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id) {

		Dept dept = service.get(id);
		if (dept == null) {
			throw new RuntimeException("该ID" + id + "没有对应的信息");
		}
		return dept;
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id) {
		return new Dept().setDeptno(id)
				.setDeptname("该ID" + id + "没有对应的信息, null--@HystrixCommand")
				.setDbsource("no this database in MYSQL");
	}
}
