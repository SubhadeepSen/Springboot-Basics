package api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@Configuration:	provides the default configuration defined in springboot
//@EntityScan:	used to scan for entity(s)[Model Class] to be used in the embedded database (H2) as model
//@EnableJpaRepositories:	used to scan the package(s) where the interface, extending the CrudRepository interface, is present

//*** All these configuration can be done in the starter class along with the @SpringBootApplication annotation. 
//*** But it is better to create separate configuration file(s) for each configuration under a config package.

@Configuration
@EntityScan("api.model")
@EnableJpaRepositories("api.repository")
public class JPAConfig {

}
