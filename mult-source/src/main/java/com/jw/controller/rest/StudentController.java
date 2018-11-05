package com.jw.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jw.domain.people.Student;
import com.jw.mybatis.dao.StuDao;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController{

	@Autowired
	private StuDao stuDao;
	
	@RequestMapping("/save")
	public Map<String, Object>  getStudentListByDataSQL(){
		
		Student student = new Student();
		student.setName("fangyuan");
		student.setAge(20L);
		student.setSex("ccc");
		int sti= stuDao.save(student);
		
		Map<String, Object>  map = new HashMap<String, Object>();
		
		map.put("result", sti);
		
		
	
		
		return map;
		
	}
	
	@RequestMapping("/findAll")
	public Map<String, Object>  saveStudent(){
		List<Student> findAll = stuDao.findAll();
		
		Map<String, Object>  map = new HashMap<String, Object>();
		
		map.put("result", findAll);
		
		return map;
	}
	
	
}
