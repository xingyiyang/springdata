package com.scu.springdata.repository;

import java.util.ArrayList;
import java.util.List;

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

public class EmployeePageSortRepositoryTest {

    private ApplicationContext context = null;
    private EmployeePageSortRepository employeePageSortRepository = null;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("spring-datadao.xml");
		employeePageSortRepository = context.getBean(EmployeePageSortRepository.class);
		System.out.println("setup");
	}
	
	@After
	public void shutdown(){
		context = null;
		System.out.println("shutdown");
	}
	
	@Test
	public void testPage() {
		
		System.out.println("testPage");
		Pageable pageable = new PageRequest(0, 5);
		Page<Employee> page = employeePageSortRepository.findAll(pageable);
		System.out.println("总页数: "+page.getTotalPages());
		System.out.println("总记录数: "+page.getTotalElements());
		System.out.println("当前第几页: "+(page.getNumber()+1));
		System.out.println("当前页面的集合: "+page.getContent());
		System.out.println("当前页面的记录数: "+page.getNumberOfElements());
	}
	
	@Test
	public void testpageAndSort(){
		
		System.out.println("testpageAndSort");
		Sort.Order orders = new Sort.Order(Sort.Direction.ASC, "id");
		Sort sort = new Sort(orders);
		Pageable pageable = new PageRequest(0,5,sort);
		Page<Employee> page = employeePageSortRepository.findAll(pageable);
		System.out.println("总页数: "+page.getTotalPages());
		System.out.println("总记录数: "+page.getTotalElements());
		System.out.println("当前第几页: "+(page.getNumber()+1));
		System.out.println("当前页面的集合: "+page.getContent());
		System.out.println("当前页面的记录数: "+page.getNumberOfElements());
	}

}
