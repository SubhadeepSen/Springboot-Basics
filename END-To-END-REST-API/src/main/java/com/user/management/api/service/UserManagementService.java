package com.user.management.api.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.management.api.model.UserDetails;
import com.user.management.api.repository.AddressRepository;
import com.user.management.api.repository.ContactRepository;
import com.user.management.api.repository.UserDetailsRepository;

/*
 * The @Service annotation creates a service bean and @Autowired annotation helps spring to inject a bean into that field, 
 * if present inside spring container.
 */

@Service
public class UserManagementService {

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	public List<UserDetails> getAllStudents() {
		return (List<UserDetails>) userDetailsRepository.findAll();
	}

	@PostConstruct
	public void initStudentDatabase() {
	}
}
