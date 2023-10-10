package in.virendraoswal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.virendraoswal.service.CountryService;

@RestController
public class ContryController {

	@Autowired
	CountryService _countryService;

	@GetMapping(path = "/country/{country}")
	public String getCapitalOfCountry(@PathVariable("country") String country) {
		return _countryService.getCapitalOfCountry(country);
	}

}
