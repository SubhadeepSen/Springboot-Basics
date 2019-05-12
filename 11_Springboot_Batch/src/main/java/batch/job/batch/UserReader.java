package batch.job.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import batch.job.model.User;

@Component
public class UserReader extends FlatFileItemReader<User> {

	public UserReader(@Value("${inputFile}") Resource resource) {
		initFileItemReader(resource);
	}

	private void initFileItemReader(Resource resource) {
		System.out.println("Initializing user reader ***");
		super.setResource(resource);
		super.setName("CSV Reader");
		super.setLinesToSkip(1);
		super.setLineMapper(lineMapper());
	}

	private LineMapper<User> lineMapper() {
		DefaultLineMapper<User> defaultLineMapper = new DefaultLineMapper<>();

		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setDelimiter("|");
		lineTokenizer.setStrict(false);
		lineTokenizer.setNames(new String[] { "id", "name", "dept", "salary" });

		BeanWrapperFieldSetMapper<User> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(User.class);

		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		return defaultLineMapper;
	}
}
