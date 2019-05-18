package profile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProfileController {

	@Value("${message}")
	private String message;

	@Value("${profile.name}")
	private String profileName;

	@Autowired
	@Qualifier("profileBean")
	private String profileBean;

	@RequestMapping("/profile")
	public String getProfileInfo() {
		return "Profile = " + profileName + " & message = " + message + " & profileBean = " + profileBean;
	}
}
