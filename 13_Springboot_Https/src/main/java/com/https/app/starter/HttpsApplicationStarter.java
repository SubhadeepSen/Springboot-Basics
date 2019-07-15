package com.https.app.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.https.*")
public class HttpsApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(HttpsApplicationStarter.class, args);
	}

}
