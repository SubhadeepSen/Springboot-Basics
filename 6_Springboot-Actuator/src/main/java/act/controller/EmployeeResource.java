package act.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import act.model.Employee;

@RestController
public class EmployeeResource {

	@RequestMapping("/employee")
	@GetMapping
	public Employee getEmployee() {
		Employee emp = new Employee();
		emp.setId(new BigDecimal("1004512"));
		emp.setName("Rahul Kumar Pattanayak");
		emp.setSalary(new BigDecimal("67458"));
		emp.setDesignation("Software Engineer");
		return emp;
	}
}
