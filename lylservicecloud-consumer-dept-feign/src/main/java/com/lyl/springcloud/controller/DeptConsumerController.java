package com.lyl.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lyl.springcloud.entities.Dept;
import com.lyl.springcloud.webservice.DeptClientService;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;//Feign面向接口编程

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id){
        //三个参数：url,requestMap ResponseBean.class
        return deptClientService.get(id);
    }
    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list(){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.list();
    }
    @RequestMapping(value = "/consumer/dept/add")
    public Object add(Dept dept){
        //三个参数：url,requestMap ResponseBean.class
        return  deptClientService.add(dept);
    }
}