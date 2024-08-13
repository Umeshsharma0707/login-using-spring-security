package com.userlogin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userlogin.models.Users;
import com.userlogin.repos.UsersRepo;

@Service
public class UserService {
	
	@Autowired
	private UsersRepo repo;
	
	public Users saveUser(Users user) {
		return this.repo.save(user);
		
	}
	
	
}
