package com.webwork.sprigdemoannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.webwork.sprigdemoannotations")
@PropertySource("classpath:sport.properties")
public class SpringConfig {
	
//	define bean for our BadFortuneService
	@Bean
	public FortuneService badFortuneService() {
		return new BadFortuneService();
	}
	
	
//	Define a Beam for our BadSwimCoach And Inject Dependency
	@Bean 
	public Coach badSwimCoach() {
		return new BadSwimCoach(badFortuneService());
	}
}
