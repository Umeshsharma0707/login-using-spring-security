package com.userlogin.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userlogin.models.Users;

public interface UsersRepo extends JpaRepository<Users, Integer>{
	
	public Users findByUsername(String username);
}
