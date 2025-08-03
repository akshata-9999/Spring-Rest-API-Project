package com.project.employeemgt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.employeemgt.entities.Employee;
import com.project.employeemgt.services.EmployeeServices;

@RestController
@RequestMapping("/employee/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeServices empServices;
	
	@PostMapping("/insert")
	public Employee insertEmp(@RequestBody Employee emp) {
		return empServices.addNewEmp(emp);
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
	    return empServices.getEmployeeById(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee emp) {
	    return ResponseEntity.ok(empServices.updateEmployee(id, emp));
	}


	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
          empServices.deleteEmployee(id);
          return ResponseEntity.ok("Employee deleted successfully");
    }
	@GetMapping("/allemployees")
	public List<Employee> getEmployees()
	{
		return empServices.getAllEmployee();
	}

}
