package com.lyl.springcloud.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable{
	 
	private static final long serialVersionUID = -1669426562991160618L;
	private Long deptno;  //主键
	private String deptname; //部门名称
	private String dbsource; //来自哪个数据库，因为微服务框架对应一个数据库，同一信息被存储到不同数据库
	
}
 