package com.jw.controller.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jw.domain.people.Student;
import com.jw.mybatis.dao.StuDao;
import com.jw.util.StringUtil;

@RestController
@RequestMapping("/student")
public class StudentController extends BaseController{

	@Autowired
	private StuDao stuDao;
	
	@RequestMapping("/save")
	public Map<String, Object>  saveStudent(){
		
		Student student = new Student();
		student.setName("fangyuan");
		student.setAge(20L);
		student.setSex("ccc");
		int sti= stuDao.save(student);//影响范围
		
		Map<String, Object>  map = new HashMap<String, Object>();
		
		map.put("result", sti);
		
		return map;
		
	}
	
	@RequestMapping("/save/student")
	public Map<String, Object> saveStudent(Student student){
		
		int influenceLineCounts= stuDao.save(student);
		
		Map<String, Object>  map = new HashMap<String, Object>();
		
		map.put("result", influenceLineCounts);
		return map;
		
	}
	
	@RequestMapping("/findAll")
	public Map<String, Object>  findAllStudent(){
		List<Student> findAll = stuDao.findAll();
		
		Map<String, Object>  map = new HashMap<String, Object>();
		
		map.put("result", findAll);
		
		return map;
	}
	
	@RequestMapping("/name/{name}")
	public Map<String, Object>  findStudentByName(@PathVariable (required = false) String name){
		Map<String, Object>  map = new HashMap<String, Object>();
		
		if (StringUtil.isNullStr(name)) {
			map.put("code", 410);
			map.put("desc", "name is null");
			return map;
		}
		
		List<Student> findAll = stuDao.findByName(name);
		
		
		map.put("code", 200);
		map.put("desc", "success");
		map.put("result", findAll);
		
		return map;
	}
	
	@RequestMapping("/nameLike/{name}")
	public Map<String, Object>  findStudentByNameLike(@PathVariable (required = false) String name){
		Map<String, Object>  map = new HashMap<String, Object>();
		
		if (StringUtil.isNullStr(name)) {
			map.put("code", 410);
			map.put("desc", "name is null");
			return map;
		}
		
		List<Student> findAll = stuDao.findByNameLike("%"+name+"%");
		
		
		map.put("code", 200);
		map.put("desc", "success");
		map.put("result", findAll);
		
		return map;
	}
	
	
}
