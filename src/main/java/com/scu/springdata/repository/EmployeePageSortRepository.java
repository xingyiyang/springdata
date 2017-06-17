package com.scu.springdata.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.scu.springdata.domain.Employee;

public interface EmployeePageSortRepository extends PagingAndSortingRepository<Employee, Integer>{

}
