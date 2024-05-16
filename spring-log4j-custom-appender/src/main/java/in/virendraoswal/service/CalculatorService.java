package in.virendraoswal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Virendra
 *
 */
@Service
public class CalculatorService {

	private static Logger LOG = LoggerFactory.getLogger(CalculatorService.class);

	public int add(int num1, int num2) {
		LOG.info("Adding 2 numbers ...");
		return num1 + num2;
	}

	public int subtract(int num1, int num2) {
		LOG.info("Substracting 2 numbers ...");
		return num1 - num2;
	}

	public int multiply(int num1, int num2) {
		LOG.info("Multiplying 2 numbers ...");
		return num1 * num2;
	}

	public int divide(int num1, int num2) {
		LOG.info("Dividing 2 numbers ...");
		try {
			return num1 / num2;
		} catch (Exception e) {
			LOG.error("Error occured during divide", e);
		}

		return 0;
	}
}
