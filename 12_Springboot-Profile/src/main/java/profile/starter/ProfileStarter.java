package profile.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="profile.*")
public class ProfileStarter {

	public static void main(String[] args) {
		SpringApplication.run(ProfileStarter.class, args);
	}

}
