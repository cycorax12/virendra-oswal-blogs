package in.virendraoswal;

import org.apache.ignite.cache.spring.SpringCacheManager;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 
 * @author Virendra
 *
 */
@Configuration
@EnableCaching
public class IgniteCacheConfig {

	@Bean
	public SpringCacheManager cacheManager() {
		SpringCacheManager mgr = new SpringCacheManager();
		mgr.setConfiguration(new IgniteConfiguration().setIgniteInstanceName("Ignite Cache Node").setMetricsLogFrequency(0));
		return mgr;
	}

}
