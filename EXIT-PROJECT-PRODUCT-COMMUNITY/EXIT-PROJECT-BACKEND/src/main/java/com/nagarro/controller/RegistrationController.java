package com.nagarro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.User;
import com.nagarro.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	@PostMapping("/registerUser")
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmailId();
		if (tempEmail != null && !"".equals(tempEmail)) {
			// if user exists with same email id it throws exception
			User obj = service.fetchUserByEmailId(tempEmail);
			if (obj != null)
				throw new Exception("User with this " + tempEmail + " already exists!!");
		}
		return service.saveUser(user);
	}
	
	@GetMapping("/TotalRegisteredUsers")
	@CrossOrigin(origins = "http://localhost:4200")
	public int getTotalRegisteredUsers() {
		return service.getTotalRegisteredUsers();
	}
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmail = user.getEmailId();
		String password = user.getPassword();
		User userObj = null;
		if ( !"".equals(tempEmail) && !"".equals(password)) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmail, password);
		}
		
		if(userObj == null)
			throw new Exception("Bad Credentials");
		
		System.out.println(userObj.getEmailId());
		System.out.println(userObj.getPassword());
		
		return userObj;
	}

}
