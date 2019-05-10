package com.ucacue.ec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.ucacue.ec"})
@EnableJpaRepositories(basePackages = {"com.ucacue.ec.persistence.repository"})
@EntityScan(basePackages = {"com.ucacue.ec.persistence.entity"})
@PropertySource("classpath:data.properties")
public class FactElectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactElectApplication.class, args);
	}

}