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

@RestController
public class DeptController {
	
	
	@Autowired
	private DeptService service;
	
	@RequestMapping(value="/dept/add", method= RequestMethod.POST)
	// @PostMapping("/dept/add")
	public boolean add(@RequestBody Dept dept){
		return service.add(dept);
	}
	
	@RequestMapping(value="/dept/get/{id}", method= RequestMethod.GET)
	// @GetMapping("/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id){
		return service.get(id);
	}
	
	@RequestMapping(value="/dept/list", method= RequestMethod.GET)
	// @GetMapping("/dept/list")
	public List<Dept> list(){
		return service.list();
	}

}
