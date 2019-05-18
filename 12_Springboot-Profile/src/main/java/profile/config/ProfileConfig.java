package profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

	@Profile("default")
	@Bean("profileBean")
	public String defaultProfile() {
		return new String("Running default profile...");
	}

	@Profile("local")
	@Bean("profileBean")
	public String localProfile() {
		return new String("Running local profile...");
	}

	@Profile("dev")
	@Bean("profileBean")
	public String devProfile() {
		return new String("Running dev profile...");
	}

	@Profile("test")
	@Bean("profileBean")
	public String testProfile() {
		return new String("Running test profile...");
	}

	@Profile("prod")
	@Bean("profileBean")
	public String prodProfile() {
		return new String("Running prod profile...");
	}
}
