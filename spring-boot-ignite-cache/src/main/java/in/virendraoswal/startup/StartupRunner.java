package in.virendraoswal.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.virendraoswal.service.EmployeeService;

/**
 * 
 * @author Virendra
 *
 */
@Component
public class StartupRunner implements ApplicationRunner {

	Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	EmployeeService _es;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOG.info("[START] Saving Employee Data");
		_es.saveAll(30000);
		LOG.info("[END] Saving Employee Data");
	}

}