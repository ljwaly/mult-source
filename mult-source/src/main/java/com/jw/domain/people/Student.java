package com.jw.domain.people;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 实体类，数据库内部信息存储
 * @author PC
 *
 */

@Entity
@Table(name="mult_student"/*,//表名字 
		uniqueConstraints = {@UniqueConstraint(columnNames = {"NAME"})}*/)//唯一约束
public class Student implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1083061564219687759L;
	
	private Long studentId;
	private String name;
	private Long age;
	private String sex;
	private String studentNumber;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "AGE")
	public Long getAge() {
		return age;
	}
	
	public void setAge(Long age) {
		this.age = age;
	}

	@Column(name = "SEX")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	

	public String getStudentNumber() {
		return studentNumber;
	}

	@Column(name = "student_number")
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", studentNumber=" + studentNumber + "]";
	}

}
