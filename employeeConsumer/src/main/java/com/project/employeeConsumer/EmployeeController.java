package com.project.employeeConsumer;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.project.employeeConsumer.models.Employee;

@Controller
public class EmployeeController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/")
	public String homePage(Model model) {
		String url = "http://localhost:8080/employee/api/allemployees";
		ResponseEntity<List<Employee>> response = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Employee>>() {
				});

		List<Employee> employees = response.getBody();
		model.addAttribute("employees", employees);

		return "index.jsp";
	}

	@GetMapping("/insertEmployee")
	public String insert() {
		return "InsertEmployee.jsp";
	}

	@PostMapping("/insertEmp")
	public String submitEmployee(@ModelAttribute Employee employee, Model model) {
		final String REST_API_URL = "http://localhost:8080/employee/api/insert";
		try {
			Employee saved = restTemplate.postForObject(REST_API_URL, employee, Employee.class);
			model.addAttribute("message", "Employee inserted: " + saved.getEmployee_name());
		} catch (Exception e) {
			model.addAttribute("message", "Failed to insert employee: " + e.getMessage());
		}
		return "redirect:/";
	}
	
	@GetMapping("/editEmp")
	public String editEmployeeForm(@RequestParam("employee_id") int employeeId, Model model) {
	    Employee emp = restTemplate.getForObject("http://localhost:8080/employee/api/employee/" + employeeId, Employee.class);
	    model.addAttribute("employee", emp);
	    return "updateEmp.jsp"; // No .jsp if your prefix/suffix is set correctly
	}

	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);

	    HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);

	    restTemplate.exchange(
	        "http://localhost:8080/employee/api/update/" + employee.getEmployee_id(),
	        HttpMethod.PUT,
	        entity,
	        Void.class
	    );

	    return "redirect:/";
	}


	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable int id) {
	    String deleteUrl = "http://localhost:8080/employee/api/delete/" + id;
	    restTemplate.delete(deleteUrl);
	    return "redirect:/";
	}


}
