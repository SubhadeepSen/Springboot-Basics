package act.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "act"})
public class ActuatorSampleStarter {

    public static void main(String[] args) throws Exception {
    	SpringApplication.run(ActuatorSampleStarter.class, args);
    }
}
