package in.virendraoswal.repository;

import java.util.List;

import in.virendraoswal.model.Employee;
import in.virendraoswal.type.Department;

/**
 * 
 * @author Virendra
 *
 */
public interface IEmployeeRepository {
	void saveAll(int numberOfRows);
	List<Employee> getEmployeesForDepartment(Department department);
}