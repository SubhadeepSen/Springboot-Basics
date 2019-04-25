package api.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "api"})
public class CustomAPIStarter {

    public static void main(String[] args) throws Exception {
    	SpringApplication.run(CustomAPIStarter.class, args);
    }
}
