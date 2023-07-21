package in.virendraoswal.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.virendraoswal.model.Employee;
import in.virendraoswal.type.Department;

/**
 * 
 * @author Virendra
 *
 */
public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new Employee(rs.getInt("id"), rs.getInt("salary"), rs.getString("name"),
				Department.valueOf(rs.getString("department")));
	}

}