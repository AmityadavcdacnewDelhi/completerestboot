package org.fi.spring.completerestboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"org.fi.spring.completerestboot.controllers","org.fi.spring.completerestboot.services"})
@EntityScan(basePackages = {"org.fi.spring.completerestboot.entity"})
@EnableJpaRepositories(basePackages = {"org.fi.spring.completerestboot.repositories"})
public class CompleterestbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompleterestbootApplication.class, args);
	}

}
