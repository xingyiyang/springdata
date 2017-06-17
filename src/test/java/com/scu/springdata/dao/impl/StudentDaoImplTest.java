package com.scu.springdata.dao.impl;

import java.util.List;

import org.junit.Test;

import com.scu.springdata.dao.StudentDao;
import com.scu.springdata.domain.Student;

public class StudentDaoImplTest {

	@Test
	public void testQueryAll() {
	
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> studentList = studentDao.queryAll();
		for(Student student:studentList){
			System.out.println(student.toString());
		}
	}
	
	@Test
	public void testStudentSave() {
	
		StudentDao studentDao = new StudentDaoImpl();
		Student student = new Student();
		student.setUsername("fty");
		student.setAge(24);
		studentDao.studentSave(student);
	}
	
	@Test
	public void testStudentById() {
	
		StudentDao studentDao = new StudentDaoImpl();
		Student student = studentDao.studentById(4);
		System.out.println(student.toString());
	}

}
