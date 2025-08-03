package com.project.employeemgt.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.employeemgt.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
