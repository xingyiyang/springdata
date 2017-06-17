package com.scu.springdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scu.springdata.domain.Employee;
import com.scu.springdata.service.EmployeeService;


public class EmployeeServiceImplTest {

	private ApplicationContext context = null;
    private EmployeeService employeeService = null;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("spring-datadao.xml");
		employeeService = context.getBean(EmployeeService.class);
		System.out.println("setup");
	}
	
	@After
	public void shutdown(){
		context = null;
		System.out.println("shutdown");
	}
	
	@Test
	public void testupdateEmployee() {
		
		System.out.println("testupdateEmployee");
		employeeService.updateEmployee(5, 18);
	}
	
	@Test
	public void testsave(){
		
		System.out.println("testsave");
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		for(int i=1;i<=100;i++){
			employee = new Employee();
			employee.setAge(i);
			employee.setName("test"+i);
			employees.add(employee);
		}
	    employeeService.save(employees);
	}

}
