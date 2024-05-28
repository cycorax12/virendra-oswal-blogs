package in.virendraoswal;

import java.util.Date;

import org.ff4j.FF4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class FF4jService {

	@Autowired
	private FF4j ff4j;

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			while (true) {
				if (ff4j.check(FF4jConfig.REGION_FEATURE)) {
					System.out.println(new Date() + " Feature Active for EMEA Region only.");
				} else {
					System.out.println(new Date() + " Feature Active for Non-EMEA region.");
				}
				if (ff4j.check(FF4jConfig.SCALE_FEATURE)) {
					System.out.println(new Date() + " Office Hour Window Activated");
				} else {
					System.out.println(new Date() + " Office Hour Window Not Active");
				}
				if (ff4j.check(FF4jConfig.RELEASE_FEATURE)) {
					System.out.println(new Date() + " New Feature Release");
				} else {
					System.out.println(new Date() + " Running on old Feature");
				}
				Thread.sleep(10000);
			}
		};
	}
}