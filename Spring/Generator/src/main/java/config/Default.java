package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import generator.Generator;
import generator.RandomGenerator;

@Configuration
@Profile("default")
public class Default {
	
	@Bean
	public Generator generator(){
		return new RandomGenerator();
	}

}
