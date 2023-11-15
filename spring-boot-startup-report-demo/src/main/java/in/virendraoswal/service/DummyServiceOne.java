package in.virendraoswal.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class DummyServiceOne {

	@PostConstruct
	void setup() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
