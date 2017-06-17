package com.scu.springdata.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.scu.springdata.domain.Employee;

public class EmployeeSpecificationExecuteRepositoryTest {

    private ApplicationContext context = null;
    private EmployeeSpecificationExecuteRepository employeeSpecificationExecuteRepository = null;
	
	@Before
	public void setup(){
		context = new ClassPathXmlApplicationContext("spring-datadao.xml");
		employeeSpecificationExecuteRepository = context.getBean(EmployeeSpecificationExecuteRepository.class);
		System.out.println("setup");
	}
	
	@After
	public void shutdown(){
		context = null;
		System.out.println("shutdown");
	}

	@Test
	public void testQueryPageBySomething(){
		
		System.out.println("testQueryPageBySomething");
		Sort.Order orders = new Sort.Order(Sort.Direction.ASC, "id");
		Sort sort = new Sort(orders);
		Pageable pageable = new PageRequest(0,5,sort);
		
		/**
		 * root 要查询的类型
		 * query 查询条件
		 * cb 构建predictation
		 */
		Specification<Employee> specification = new Specification<Employee>() {

			public Predicate toPredicate(Root<Employee> root, 
					CriteriaQuery<?> query, 
					CriteriaBuilder cb) {
				Path path = root.get("age");
				return cb.gt(path, 50);
			}
		};
		
		Page<Employee> page = employeeSpecificationExecuteRepository.findAll(specification,pageable);
		System.out.println("总页数: "+page.getTotalPages());
		System.out.println("总记录数: "+page.getTotalElements());
		System.out.println("当前第几页: "+(page.getNumber()+1));
		System.out.println("当前页面的集合: "+page.getContent());
		System.out.println("当前页面的记录数: "+page.getNumberOfElements());
	}

}
