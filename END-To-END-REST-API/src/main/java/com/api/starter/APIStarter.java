package com.api.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * The @SpringBootApplication annotation helps spring to start its execution and performs boostraping(Auto-Configuration)
 * The scanBasePackages parameter allows spring to scan into the given packages and sub-packages to identify the annotated classes to create beans.
 * The @EntityScan annotation helps spring to identify the models annotated with @Entity in the specified package.
 * The @EnableJpaRepositories helps spring to enable the JPA Repositories and create beans in the specified package.
 */

@SpringBootApplication(scanBasePackages = "com.api.*")
@EntityScan("com.api.model")
@EnableJpaRepositories("com.api.repository")
public class APIStarter {

	public static void main(String[] args) {
		SpringApplication.run(APIStarter.class, args);
	}
}
