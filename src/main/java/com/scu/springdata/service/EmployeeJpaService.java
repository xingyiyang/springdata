package com.scu.springdata.service;

import java.util.List;

import com.scu.springdata.domain.Employee;

public interface EmployeeJpaService {

	public void delete(int id);
	
	public void deletebatch(List<Employee> employees);
	
	public void save(Employee employee);
	
	public boolean exists(int id);
	
	public long count();
	
	public Employee findOne(int id);
	
	public List<Employee> findAll();
}
