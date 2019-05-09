package batch.job.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import batch.job.model.User;

@Component
public class UserProcessor implements ItemProcessor<User, User> {

	private Map<String, String> deptName;

	public UserProcessor() {
		deptName = new HashMap<>();
		deptName.put("001", "Technology");
		deptName.put("002", "Finance");
		deptName.put("003", "Bank");
	}

	@Override
	public User process(User user) throws Exception {
		String deptCode = user.getDept();
		String dept = deptName.get(deptCode);
		user.setDept(dept);
		System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
		return user;
	}

}
