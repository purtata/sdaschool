package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import generator.EvenNumberGenerator;
import generator.Generator;

@Configuration
@Profile("evenNumbers")
public class EvenCfg {
	
	@Bean
	public Generator generator(){
		return new EvenNumberGenerator();
	}

}
