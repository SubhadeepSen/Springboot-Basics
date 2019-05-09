package activemq.mq.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "activemq.mq.*")
public class ActiveMQStarter {

	public static void main(String[] args) {
		SpringApplication.run(ActiveMQStarter.class, args);
	}

}
