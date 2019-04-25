package api.starter;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import api.client.RestClient;

//************** SPRINGBOOT APPLICATION FOR CONSUMING RESTFUL WEB SERVICES [REST API] **************

@SpringBootApplication
public class RESTAPIStarter extends SpringBootServletInitializer {

	public static void main(String[] args)  {
		SpringApplication.run(RESTAPIStarter.class, args);
		try {
			JSONObject books = RestClient.getEntity();
			System.out.println(books);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RESTAPIStarter.class);
	}
}
