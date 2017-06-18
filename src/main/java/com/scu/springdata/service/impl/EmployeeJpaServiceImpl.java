package com.scu.springdata.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scu.springdata.domain.Employee;
import com.scu.springdata.repository.EmployeeJpaRepository;
import com.scu.springdata.repository.EmployeeRepository;
import com.scu.springdata.service.EmployeeJpaService;


@Service
public class EmployeeJpaServiceImpl implements EmployeeJpaService{

	@Autowired
	private EmployeeJpaRepository employeeJpaRepository;
    
	public void delete(int id){
		employeeJpaRepository.delete(id);
	}
	
	public void deletebatch(List<Employee> employees){
		employeeJpaRepository.delete(employees);
	}
	
	@Transactional
	public void save(Employee employee){
		employeeJpaRepository.save(employee);
		
	}
	
	public boolean exists(int id){
		return employeeJpaRepository.exists(id);
	}
	
	public long count(){
		return employeeJpaRepository.count();
	}
	
	public List<Employee> findAll(){
		List<Employee> list = new ArrayList<Employee>();
		list = employeeJpaRepository.findAll();
		return list;
	}
	
	public Employee findOne(int id){
		return employeeJpaRepository.findOne(id);
	}
	
	
}
