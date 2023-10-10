package in.virendraoswal.service;

@org.springframework.stereotype.Service
public class CountryService {
	public String getCapitalOfCountry(String country) {
		switch (country.toLowerCase()) {
		case "india":
			return "New Delhi";
		case "egypt":
			return "Cairo";
		case "france":
			return "Paris";
		case "germany":
			return "Berlin";
		case "china":
			return "Beijing";
		default:
			return "Unknown";

		}
	}

	public void wontBeInvoked() {
		System.out.println("Do Nothing.");
	}
}
