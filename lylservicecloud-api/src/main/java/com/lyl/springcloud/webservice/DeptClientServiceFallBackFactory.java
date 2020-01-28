package com.lyl.springcloud.webservice;

import java.util.List;

import org.springframework.stereotype.Component;

import com.lyl.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;
/*
 * 服务降级是在客户端实现完成的，与服务端没有关系  FallBackFactory实现熔断服务
 */
@Component  //!!不要忘记添加
public class DeptClientServiceFallBackFactory implements FallbackFactory<DeptClientService> {
	//创建熔断的方法
	@Override
	public DeptClientService create(Throwable cause) {
		// TODO Auto-generated method stub
		return new DeptClientService() {
			
			@Override
			public List<Dept> list() {
				// TODO Auto-generated method stub
				return null;
			}
			@Override
			public Dept get(Long id) {
				// TODO Auto-generated method stub
				return new Dept().setDeptno(id)
						.setDeptname("该ID" + id + "没有对应的信息, Consumer客户端提供的降级信息，此刻服务Provider已经关闭")
						.setDbsource("no this database in MYSQL");
			}	
			@Override
			public boolean add(Dept dept) {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}
}
