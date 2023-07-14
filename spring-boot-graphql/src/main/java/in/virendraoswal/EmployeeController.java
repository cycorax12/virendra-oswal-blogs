package in.virendraoswal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import in.virendraoswal.model.Department;
import in.virendraoswal.model.Employee;
import in.virendraoswal.model.EmployeeInput;
import in.virendraoswal.repository.DepartmentRepository;
import in.virendraoswal.repository.EmployeeRepository;

@Controller
public class EmployeeController {
	
	
	@Autowired
	EmployeeRepository employeeRepository;

	@QueryMapping
	public Employee employeeById(@Argument String id) {
		return employeeRepository.getById(id);
	}

	@SchemaMapping
	public Department department(Employee employee) {
		return DepartmentRepository.getById(employee.departmentId());
	}

	@SchemaMapping(typeName = "Query")
	public List<Employee> employees() {
		return employeeRepository.employees();
	}
	
	@MutationMapping
	public Employee addEmployee(@Argument EmployeeInput employee) {
		return employeeRepository.addEmployee(employee);
	}
	

}
