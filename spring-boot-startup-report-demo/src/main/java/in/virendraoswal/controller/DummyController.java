package in.virendraoswal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import in.virendraoswal.service.DummyServiceOne;
import in.virendraoswal.service.DummyServiceTwo;

@RestController
public class DummyController {

	@Autowired
	DummyServiceOne _serviceOne;

	@Autowired
	DummyServiceTwo _serviceTwo;

	public DummyController() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
