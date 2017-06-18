package com.scu.springdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scu.springdata.domain.Employee;
import com.scu.springdata.service.EmployeeJpaService;
import com.scu.springdata.service.EmployeeService;


public class EmployeeJpaServiceImplTest {

	private ApplicationContext context = null;
    private EmployeeJpaService employeeJpaService = null;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("spring-datadao.xml");
		employeeJpaService = context.getBean(EmployeeJpaService.class);
		System.out.println("setup");
	}
	
	@After
	public void shutdown(){
		context = null;
		System.out.println("shutdown");
	}
	
	@Test
	public void testdelete() {
		
		System.out.println("testdelete");
		employeeJpaService.delete(5);
	}
	
	@Test
	public void testdeletebatch(){
		
		System.out.println("testdeletebatch");
		List<Employee> list = new ArrayList<Employee>();
		list.add(employeeJpaService.findOne(7));
		list.add(employeeJpaService.findOne(8));
		list.add(employeeJpaService.findOne(9));
		employeeJpaService.deletebatch(list);
	}
	
	@Test
	public void testsave(){
		
		System.out.println("testsave");
		Employee employee = new Employee();
		employee.setAge(17);
		employee.setName("fttty");
	    employeeJpaService.save(employee);
	}
	
	@Test
	public void testexists(){
		
		System.out.println("testexists");
		System.out.println("id=1: " +employeeJpaService.exists(1));
		System.out.println("id=100: " +employeeJpaService.exists(100));
	}
	
	@Test
	public void testcount(){
		
		System.out.println("testcount");
		System.out.println("count : " +employeeJpaService.count());
	}
	
	@Test
	public void testfindAll(){
		
		System.out.println("testfindAll");
		List<Employee> list = new ArrayList<Employee>();
		list = employeeJpaService.findAll();
		for(Employee employee:list){
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testfindOne(){
		
		System.out.println("testfindOne");
		Employee employee = employeeJpaService.findOne(1);
		System.out.println(employee.toString());
		Employee employee2 = employeeJpaService.findOne(100);
		System.out.println(employee2);
	}

}
