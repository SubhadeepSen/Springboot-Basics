package api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import api.endpoint.UserEndpoint;
import api.exception.NoDataFoundException;
import api.model.User;
import api.service.UserService;

@Controller
public class UserController implements UserEndpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	public ResponseEntity<List<User>> gerUsers() {
		try {
			return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
		} catch (NoDataFoundException e) {
			LOGGER.info("Users ---> " + e.getMessage());
		}
		return new ResponseEntity<List<User>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
	}

}
