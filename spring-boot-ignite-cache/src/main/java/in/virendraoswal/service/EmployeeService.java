package in.virendraoswal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.virendraoswal.model.Employee;
import in.virendraoswal.repository.IEmployeeRepository;
import in.virendraoswal.type.Department;

/**
 * 
 * @author Virendra
 *
 */
@Service
public class EmployeeService {

	@Autowired
	IEmployeeRepository _ier;

	public void saveAll(int numberOfRows) {
		Employee s = new Employee(null, null, null, null);
		s.getSalary();

		_ier.saveAll(numberOfRows);
	}

	public List<Employee> getEmployeesForDepartment(Department department) {
		return _ier.getEmployeesForDepartment(department);
	}
}