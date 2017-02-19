package config;

import generator.Machine;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;


@Configuration
@Import({Default.class, OddCfg.class, EvenCfg.class})
@ComponentScan(basePackageClasses = Machine.class)
@PropertySource("classpath:config.properties")
public class Config {

}

