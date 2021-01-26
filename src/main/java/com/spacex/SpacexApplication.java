package com.spacex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableJpaRepositories(basePackages = {"com.spacex"})
@EnableCaching
public class SpacexApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpacexApplication.class, args);
		System.out.println("testando spacexxxxxxxxxxx");
	}

}
