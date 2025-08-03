package com.project.employeemgt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.employeemgt.entities.Employee;
import com.project.employeemgt.repositories.EmployeeRepository;

@Service
public class EmployeeServices {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee addNewEmp(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Employee updateEmployee(int id, Employee updatedEmp) {
        Employee existingEmp = empRepo.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

        existingEmp.setEmployee_name(updatedEmp.getEmployee_name());
        existingEmp.setEmployee_phone(updatedEmp.getEmployee_phone());
        existingEmp.setEmployee_gender(updatedEmp.getEmployee_gender());
        existingEmp.setEmployee_salary(updatedEmp.getEmployee_salary());
        existingEmp.setEmployee_role(updatedEmp.getEmployee_role());

        return empRepo.save(existingEmp);
    }
	
	public void deleteEmployee(int id) {
	    empRepo.deleteById(id);
	}

	
	public List<Employee> getAllEmployee()
	{
		return empRepo.findAll();
	}
	
	public Employee getEmployeeById(int id) {
        return empRepo.findById(id)
               .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

}
