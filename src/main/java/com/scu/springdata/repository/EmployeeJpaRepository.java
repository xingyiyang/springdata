package com.scu.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scu.springdata.domain.Employee;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer>{

}
