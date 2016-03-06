package org.example.web;

import org.example.domain.app.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping("/user")
	public User getUser(@RequestParam(value = "name") String name) {
		final String sanitizedName = "..."; // TODO actually sanitize the param  
		return new User("username:" + sanitizedName);
	}

}
