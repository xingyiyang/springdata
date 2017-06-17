package com.scu.springdata.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scu.springdata.domain.Employee;

public class EmployeeRepositoryTest {

    private ApplicationContext context = null;
    private EmployeeRepository employeeRepository = null;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("spring-datadao.xml");
		employeeRepository = context.getBean(EmployeeRepository.class);
		System.out.println("setup");
	}
	
	@After
	public void shutdown(){
		context = null;
		System.out.println("shutdown");
	}
	
	@Test
	public void testFindByName() {
		
		System.out.println("testFindByName");
		Employee employee = employeeRepository.findByName("fty");
		System.out.println(employee.toString());
	}
	
	@Test
	public void testfindByNameStartingWithAndAgeLessThan(){
		
		System.out.println("findByNameStartingWithAndAgeLessThan");
		List<Employee> list = employeeRepository.findByNameStartingWithAndAgeLessThan("ft", 24);
		for(Employee employee:list){
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testfindByNameEndingWithAndAgeLessThan(){
		
		System.out.println("findByNameEndingWithAndAgeLessThan");
		List<Employee> list = employeeRepository.findByNameEndingWithAndAgeLessThan("yy", 17);
		for(Employee employee:list){
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testfindByNameInOrAgeLessThan(){
		
		System.out.println("findByNameInOrAgeLessThan");
		List<String> names = new ArrayList<String>();
        names.add("fty");
        names.add("ftty");
        names.add("ftyy");
		List<Employee> list = employeeRepository.findByNameInOrAgeLessThan(names, 22);
		for(Employee employee:list){
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testfindByNameInAndAgeLessThan(){
		
		System.out.println("findByNameInAndAgeLessThan");
		List<String> names = new ArrayList<String>();
        names.add("fty");
        names.add("ftty");
        names.add("ftyy");
		List<Employee> list = employeeRepository.findByNameInAndAgeLessThan(names, 22);
		for(Employee employee:list){
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testgetEmployeeByMaxId(){
		
		System.out.println("getEmployeeByMaxId");
		Employee employee = employeeRepository.getEmployeeByMaxId();
		System.out.println(employee.toString());
	}
	
	@Test
	public void testqueryEmployeeByNameAge(){
		
		System.out.println("queryEmployeeByNameAge");
		List<Employee> list = employeeRepository.queryEmployeeByNameAge("fty", 24);
		for(Employee employee:list){
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testqueryEmployeeByNameAge2(){
		
		System.out.println("queryEmployeeByNameAge2");
		List<Employee> list = employeeRepository.queryEmployeeByNameAge2("fty", 24);
		for(Employee employee:list){
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testqueryLike1(){
		
		System.out.println("queryLike1");
		List<Employee> list = employeeRepository.queryLike1("ft");
		for(Employee employee:list){
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testqueryLike2(){
		
		System.out.println("queryLike2");
		List<Employee> list = employeeRepository.queryLike2("ft");
		for(Employee employee:list){
			System.out.println(employee.toString());
		}
	}
	
	@Test
	public void testgetCount(){
		
		System.out.println("getCount");
		long count = employeeRepository.getCount();
		System.out.println("count :" +count);
	}

}
