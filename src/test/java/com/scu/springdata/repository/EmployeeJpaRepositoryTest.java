package com.scu.springdata.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.scu.springdata.domain.Employee;

public class EmployeeJpaRepositoryTest {

    private ApplicationContext context = null;
    private EmployeeJpaRepository employeeJpaRepository = null;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("spring-datadao.xml");
		employeeJpaRepository = context.getBean(EmployeeJpaRepository.class);
		System.out.println("setup");
	}
	
	@After
	public void shutdown(){
		context = null;
		System.out.println("shutdown");
	}
	
	@Test
	public void testFindOne() {
		
		System.out.println("testFindOne");
		Employee employee = employeeJpaRepository.findOne(99);
		System.out.println(employee.toString());
	}
	
	@Test
	public void testFindExists(){
		
		System.out.println("testFindExists");
		System.out.println("employee(99): "+employeeJpaRepository.exists(99));
		System.out.println("employee(101): "+employeeJpaRepository.exists(101));
	}
	

}
