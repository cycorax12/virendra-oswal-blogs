package in.virendraoswal.repository;

import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.github.javafaker.Faker;

import in.virendraoswal.model.Employee;
import in.virendraoswal.repository.mapper.EmployeeRowMapper;
import in.virendraoswal.type.Department;

/**
 * 
 * @author Virendra
 *
 */
@Repository
public class EmployeeRepository implements IEmployeeRepository {

	Logger LOG = LoggerFactory.getLogger(getClass());

	private Faker faker = new Faker();

	private JdbcTemplate jdbcTemplate;

	private Random random = new Random();

	final Department[] departments = { Department.HR, Department.LEGAL, Department.FINANCE };

	public EmployeeRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public void saveAll(int numberOfRows) {
		for (int i = 0; i < numberOfRows; i++) {
			jdbcTemplate.update("INSERT INTO employee (name, department, salary) " + "VALUES (?, ?, ?)",
					faker.name().firstName(), departments[random.nextInt(3)].name(),
					faker.number().numberBetween(10000, 10000000));
		}
	}

	@Override
	@Cacheable(value = "employee")
	public List<Employee> getEmployeesForDepartment(Department department) {
		LOG.info("Read data from database.");
		return jdbcTemplate.query("select * from employee where department = '" + department + "'",
				new EmployeeRowMapper());
	}

}