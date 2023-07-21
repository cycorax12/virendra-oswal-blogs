package in.virendraoswal.model;

import in.virendraoswal.type.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Virendra
 *
 */

@Getter
@Setter
@AllArgsConstructor
public class Employee {

	private Integer id, salary;
	private String name;
	private Department department;

}
