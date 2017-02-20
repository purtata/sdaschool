package config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import car.Car;
import factory.DokkerFactory;
import factory.DusterFactory;
import factory.Factory;
import factory.LodgyFactory;
import factory.LoganFactory;
import factory.SanderoFactory;
import resources.Color;
import resources.Level;


@Configuration
@ComponentScan(basePackageClasses = {Factory.class, Car.class})
@PropertySource("classpath:config.properties")
public class Config {
	
    @Bean
    @Profile("sandero")
    public Factory factorySand() {
        return new SanderoFactory();
    }
    
    @Bean
    @Profile("dokker")
    public Factory factoryDok() {
        return new DokkerFactory();
    }
    
    @Bean
    @Profile("duster")
    public Factory factoryDus() {
        return new DusterFactory();
    }
    
    @Bean
    @Profile("logan")
    public Factory factoryLog() {
        return new LoganFactory();
    }
    
    @Bean
    @Profile("lodgy")
    public Factory factoryLod() {
        return new LodgyFactory();
    }

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
