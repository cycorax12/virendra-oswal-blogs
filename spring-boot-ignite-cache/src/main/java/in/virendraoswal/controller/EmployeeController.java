package in.virendraoswal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.virendraoswal.model.Employee;
import in.virendraoswal.service.EmployeeService;
import in.virendraoswal.type.Department;

/**
 * 
 * @author Virendra
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService _es;

	@GetMapping(path = "/deparment/employees/{department}")
	public List<Employee> getEmployeesForDepartment(@PathVariable("department") Department department) {
		return _es.getEmployeesForDepartment(department);
	}

}
