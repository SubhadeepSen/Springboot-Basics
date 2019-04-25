package embedded.mongo.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

import cz.jirutka.spring.embedmongo.EmbeddedMongoFactoryBean;

@Configuration
@EnableMongoRepositories(basePackages = "embedded.mongo.*")
public class EmbeddedMongoConfig {

	private static final String MONGO_DB_HOST = "localhost";
	private static final int MONGO_DB_PORT = 27017;
	private static final String MONGO_DB_NAME = "embeded_db";

	@Bean
	public MongoTemplate mongoTemplate() throws IOException {
		// Embedded Configuration
		EmbeddedMongoFactoryBean factoryBean = new EmbeddedMongoFactoryBean();
		factoryBean.setBindIp(MONGO_DB_HOST);
		factoryBean.setPort(MONGO_DB_PORT);
		MongoClient mongoClient = factoryBean.getObject();

		/*
		 * //External DB Configuration 
		 * MongoClient mongoClient = new MongoClient(MONGO_DB_HOST, MONGO_DB_PORT);
		 */

		MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, MONGO_DB_NAME);
		return mongoTemplate;
	}
}
