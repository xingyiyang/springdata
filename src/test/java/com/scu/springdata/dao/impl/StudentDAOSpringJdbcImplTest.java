package com.scu.springdata.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scu.springdata.dao.StudentDao;
import com.scu.springdata.domain.Student;

public class StudentDAOSpringJdbcImplTest {

	private ApplicationContext context = null;
    private StudentDao studentDao = null;
	
    @Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("spring-dao.xml");
		studentDao = (StudentDao)context.getBean("studentDAO");
		System.out.println("setup");
	}
    
    @After
	public void shutdown(){
		context = null;
		System.out.println("shutdown");
	}
    
	@Test
	public void testQueryAll() {
	
		List<Student> studentList = studentDao.queryAll();
		for(Student student:studentList){
			System.out.println(student.toString());
		}
	}
	
	@Test
	public void testStudentSave() {
	
		Student student = new Student();
		student.setUsername("ftty");
		student.setAge(23);
		studentDao.studentSave(student);
	}
	
	@Test
	public void testStudentById() {
	
		Student student = studentDao.studentById(4);
		System.out.println(student.toString());
	}

}
