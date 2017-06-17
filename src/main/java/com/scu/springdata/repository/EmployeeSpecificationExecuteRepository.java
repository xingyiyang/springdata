package com.scu.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.scu.springdata.domain.Employee;

public interface EmployeeSpecificationExecuteRepository extends 
JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee>{

}
