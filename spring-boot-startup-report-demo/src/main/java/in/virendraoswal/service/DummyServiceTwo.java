package in.virendraoswal.service;

import org.springframework.stereotype.Service;

@Service
public class DummyServiceTwo {

	public DummyServiceTwo() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
