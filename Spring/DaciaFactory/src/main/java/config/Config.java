package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import car.Car;

import factory.Factory;

import resources.Color;
import resources.Level;


@Configuration
@ComponentScan(basePackageClasses = {Factory.class})
@PropertySource("classpath:config.properties")
public class Config {

    @Bean
    public Color defColor(){
    	return Color.WHITE;
    }
    
    @Bean
    public Level defLevel(){
    	return Level.ACCESS;
    }
    
    @Bean
    public List<Car> list(){
    	return new ArrayList<Car>();
    }
    
}
