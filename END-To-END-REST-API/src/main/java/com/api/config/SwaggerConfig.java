package com.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * ### SWAGGER CONFIGURATION
 * 
 * The @EnableSwagger2 annotation tells Spring to enable Swagger Support to this application.
 * The @Configuration annotation creates a configuration bean inside spring container.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

	// A Docket bean must be required to configure and enable swagger.
	// Scans the given base package and provides Swagger support to it.
	@Bean
	public Docket docketConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.api.controller")).build().apiInfo(buildApiInfo());
	}

	// Provides basic information about the API in documentation
	private ApiInfo buildApiInfo() {
		return new ApiInfoBuilder().title("Student Management API").description("A simple api for student management.")
				.contact(new Contact("Subhadeep Sen", "", "")).version("0.0.1").build();
	}
}
