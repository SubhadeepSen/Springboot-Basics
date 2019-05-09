package batch.job.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "batch.job.*")
public class BatchStarter {

	public static void main(String[] args) {
		SpringApplication.run(BatchStarter.class, args);
	}

}
