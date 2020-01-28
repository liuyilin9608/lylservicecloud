package com.lyl.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lyl.springcloud.entities.Dept;

@Mapper
public interface DeptDao {
	
	/**
     * 插入
     * @param deptEntity
     *
     * @return
     */
    boolean addDept(Dept dept);

    /**
     * 根据id查找
     * @param deptNo
     * @return
     */
    Dept findById(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    List<Dept> findAll();
}
