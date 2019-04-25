package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.builder.UserBuilder;
import api.exception.NoDataFoundException;
import api.model.User;

@Service
public class UserService {

	@Autowired
	private UserBuilder userBuilder;

	public List<User> getUsers() throws NoDataFoundException {
		List<User> users = userBuilder.buildUsers();
		if(!users.isEmpty())
			return users;
		throw new NoDataFoundException("No data found!");
	}
}
