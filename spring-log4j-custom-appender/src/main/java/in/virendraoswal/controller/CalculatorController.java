package in.virendraoswal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.virendraoswal.service.CalculatorService;

/**
 * 
 * @author Virendra
 *
 */
@RestController
public class CalculatorController {

	@Autowired
	CalculatorService calculatorService;

	@GetMapping("/add")
	public int add(@RequestParam int num1, @RequestParam int num2) {
		return calculatorService.add(num1, num2);
	}

	@GetMapping("/subtract")
	public int subtract(@RequestParam int num1, @RequestParam int num2) {
		return calculatorService.subtract(num1, num2);
	}

	@GetMapping("/multiply")
	public int multiply(@RequestParam int num1, @RequestParam int num2) {
		return calculatorService.multiply(num1, num2);
	}

	@GetMapping("/divide")
	public int divide(@RequestParam int num1, @RequestParam int num2) {
		return calculatorService.divide(num1, num2);
	}

}
