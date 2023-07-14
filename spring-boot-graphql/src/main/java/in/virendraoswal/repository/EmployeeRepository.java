package in.virendraoswal.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import in.virendraoswal.model.Employee;
import in.virendraoswal.model.EmployeeInput;
import jakarta.annotation.PostConstruct;

@Repository
public class EmployeeRepository {
	private List<Employee> employeeData;

	public Employee getById(String id) {
		return employeeData.stream().filter(book -> book.id().equals(id)).findFirst().orElse(null);
	}

	public List<Employee> employees() {
		return employeeData;
	}

	public Employee addEmployee(EmployeeInput employee) {
		String id = String.valueOf(System.currentTimeMillis());
		Employee newEmp = new Employee(id, employee.name(), employee.salary(), employee.departmentId());
		employeeData.add(newEmp);
		return newEmp;
	}

	@PostConstruct
	public void setupData() {
		employeeData = new ArrayList<>();
		employeeData.add(new Employee("e-1", "Joshua", 23000, "d-1"));
		employeeData.add(new Employee("e-2", "Karen", 15000, "d-2"));
		employeeData.add(new Employee("e-3", "Mitchell", 19000, "d-3"));
	}
}
