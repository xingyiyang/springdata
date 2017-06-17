package com.scu.springdata.service;

import java.util.List;

import com.scu.springdata.domain.Employee;

public interface EmployeeService {

	public void updateEmployee(Integer id, Integer age);
	
	public void save(List<Employee> employees);
}
