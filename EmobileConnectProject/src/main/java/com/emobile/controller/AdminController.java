package com.emobile.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emobile.model.Admin;
import com.emobile.model.User;
import com.emobile.repository.AdminRepository;
import com.emobile.repository.UserRepository;

@Controller
@RequestMapping(value = "/eMobileConnect/admin/", method = RequestMethod.GET)
public class AdminController {
	
	@Autowired
	AdminRepository adminRepo;
	@Autowired
	UserRepository userRepo;
	
	@PostMapping("{adminId}/{name1}/{name2}/{email}")
	public void createAdmin(@PathVariable int adminId, @PathVariable String name1,
			@PathVariable String name2, @PathVariable String email) {
		
		Admin admin = new Admin(adminId, name1, name2, email);
		adminRepo.save(admin);
		User user = new User(999, "Dan", "Danny", "email.com", "7164318184", "Add", "Apex", "NC", 50000, "list", "InProgress", "700000");
		userRepo.save(user);
		user = new User(123, "Sajan", "Reddy", "email.com", "7164318184", "Add", "Apex", "NC", 50000, "list", "InProgress", "700000");
		userRepo.save(user);
	}
	
	@GetMapping("{adminId}/requestTracking")
	public List<User> getUsers(@PathVariable int adminId) {
		
		List<User> userList = new ArrayList<>();
		
		if (adminRepo.existsById(adminId)) {
			 userList = (List<User>) userRepo.findAll();
		}
		for (User user: userList) {
			System.out.println(user.getStatus());
		}
		return userList;
	}

	@PostMapping("{adminId}/approve/{request_id}")
	public void approveUser(@PathVariable int adminId, @PathVariable long request_id) {
		
		if(adminRepo.existsById(adminId) && userRepo.existsById(request_id)) {
			User user = userRepo.findById(request_id).get();
			user.setStatus("APPROVED");
			userRepo.save(user);
		}
	}
	
	@PostMapping("{adminId}/reject/{request_id}")
	public void rejectUser(@PathVariable int adminId, @PathVariable long request_id) {
		
		if(adminRepo.existsById(adminId) && userRepo.existsById(request_id)) {
			User user = userRepo.findById(request_id).get();
			user.setStatus("REJECTED");
			userRepo.save(user);
		}
	}
	
}
