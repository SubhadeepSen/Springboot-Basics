package com.api.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.api.*")
@EntityScan("com.api.model")
@EnableJpaRepositories("com.api.repository")
public class APIStarter {

	public static void main(String[] args) {
		SpringApplication.run(APIStarter.class, args);
	}
}
