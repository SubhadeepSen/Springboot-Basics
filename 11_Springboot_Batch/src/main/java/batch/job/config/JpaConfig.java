package batch.job.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("batch.job.model")
@EnableJpaRepositories("batch.job.repository")
public class JpaConfig {

}
