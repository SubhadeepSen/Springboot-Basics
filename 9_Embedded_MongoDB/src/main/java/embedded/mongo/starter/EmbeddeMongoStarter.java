package embedded.mongo.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "embedded.mongo.*")
public class EmbeddeMongoStarter {

	public static void main(String[] args) {
		SpringApplication.run(EmbeddeMongoStarter.class, args);
	}

}
