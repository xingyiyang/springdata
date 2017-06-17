package com.scu.springdata.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scu.springdata.domain.Employee;
import com.scu.springdata.repository.EmployeeCrudRepository;
import com.scu.springdata.repository.EmployeeRepository;
import com.scu.springdata.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeCrudRepository employeeCrudRepository;
	
	@Transactional
	public void updateEmployee(Integer id, Integer age) {
		
		employeeRepository.updateEmployee(id, age);
	}
	
	@Transactional
	public void save(List<Employee> employees){
		
		employeeCrudRepository.save(employees);
	}

}
