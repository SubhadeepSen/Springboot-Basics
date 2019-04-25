package api.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//************** SPRINGBOOT APPLICATION FOR DEVELOPING SIMPLE RESTFUL WEB SERVICES [REST API] **************

//@SpringBootApplication:	defines a springboot application and helps to start the application with springboot configurations
//scanBasePackages: scans for annotates fields in the specified package(s)
//@ComponentScan(basePackages = "api.*"):	same [scans for annotates fields in the specified package(s)]

@SpringBootApplication(scanBasePackages = "api.*")
public class RESTAPIStarter extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RESTAPIStarter.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RESTAPIStarter.class);
	}
}