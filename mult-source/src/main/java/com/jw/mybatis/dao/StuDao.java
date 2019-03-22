package com.jw.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jw.domain.people.Student;

/**
 * 学生表的Dao组件
 * @author PC
 *
 */
@Mapper
public interface StuDao {
	List<Student> findAll();

	int save(Student student);
	
	List<Student> findByName(String name);
	
	List<Student> findByNameLike(String nameLike);
	
}
