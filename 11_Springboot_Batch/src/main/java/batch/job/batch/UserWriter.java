package batch.job.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import batch.job.model.User;
import batch.job.repository.UserRepository;

@Component
public class UserWriter implements ItemWriter<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void write(List<? extends User> users) throws Exception {
		System.out.println("Data saved for user: " + users);
		userRepository.saveAll(users);
	}

}
