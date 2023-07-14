package in.virendraoswal.repository;

import java.util.Arrays;
import java.util.List;

import in.virendraoswal.model.Department;

public class DepartmentRepository {
	private static List<Department> departments = Arrays.asList(new Department("d-1", "HR", "Sydney"),
			new Department("d-2", "Finance", "Paris"), new Department("d-3", "Legal", "Mumbai"));

	public static Department getById(String id) {
		return departments.stream().filter(Department -> Department.id().equals(id)).findFirst().orElse(null);
	}
}
