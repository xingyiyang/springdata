package com.scu.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.scu.springdata.domain.Employee;

public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer>{

}
