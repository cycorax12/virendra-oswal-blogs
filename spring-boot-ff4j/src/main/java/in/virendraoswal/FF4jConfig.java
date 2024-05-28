package in.virendraoswal;

import java.util.HashMap;
import java.util.Map;

import org.ff4j.FF4j;
import org.ff4j.core.Feature;
import org.ff4j.core.FlippingExecutionContext;
import org.ff4j.core.FlippingStrategy;
import org.ff4j.strategy.RegionFlippingStrategy;
import org.ff4j.strategy.time.OfficeHourStrategy;
import org.ff4j.strategy.time.ReleaseDateFlipStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FF4jConfig {

	public static final String RELEASE_FEATURE = "releaseFeature";
	public static final String SCALE_FEATURE = "scaleFeature";
	public static final String REGION_FEATURE = "regionFeature";

	@Bean
	public FF4j ff4j() {
		FF4j ff4j = new FF4j();

		FlippingStrategy releaseDateStrategy = new ReleaseDateFlipStrategy("2024-05-28-14:26");
		Feature releaseFeature = new Feature(RELEASE_FEATURE);
		releaseFeature.setEnable(true);
		releaseFeature.setFlippingStrategy(releaseDateStrategy);

		ff4j.createFeature(releaseFeature);

		Feature scaleFeature = new Feature(SCALE_FEATURE);
		FlippingStrategy officeStrategy = new OfficeHourStrategy();
		Map<String, String> officeWindow = new HashMap<>();
		officeWindow.put("tuesday", "14:37-14:38,14:39-14:40");
		officeStrategy.init(SCALE_FEATURE, officeWindow);
		scaleFeature.setFlippingStrategy(officeStrategy);
		scaleFeature.setEnable(true);

		ff4j.createFeature(scaleFeature);

		RegionFlippingStrategy regionStrategy = new RegionFlippingStrategy();
		Map<String, String> regionParams = new HashMap<>();
		regionParams.put("environments", "ASPAC,NAM");
		regionStrategy.init(REGION_FEATURE, regionParams);
		Feature regionFeature = new Feature(REGION_FEATURE);
		regionFeature.setEnable(true);
		regionFeature.setFlippingStrategy(regionStrategy);

		ff4j.createFeature(regionFeature);

		Map<String, Object> initParams = new HashMap<>();
		initParams.put("region", "EMEA");
		FlippingExecutionContext context = new FlippingExecutionContext(initParams);

		ThreadLocal<FlippingExecutionContext> regionContext = new ThreadLocal<>();
		regionContext.set(context);
		ff4j.setFlippingExecutionContext(regionContext);

		return ff4j;

	}
}
