package com.nagarro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.User;
import com.nagarro.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public User fetchUserByEmailId(String email) {

		return repo.findByEmailId(email);
	}
	
	public int getTotalRegisteredUsers() {
		return repo.findAll().size();
	}

	public User fetchUserByEmailIdAndPassword(String email, String password) {

		return repo.findByEmailIdAndPassword(email, password);
	}
}
