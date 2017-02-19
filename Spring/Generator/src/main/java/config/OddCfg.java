package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import generator.Generator;
import generator.OddNumberGenerator;

@Configuration
@Profile("oddNumbers")
public class OddCfg {
	
	@Bean
	public Generator generator(){
		return new OddNumberGenerator();
	}


}
