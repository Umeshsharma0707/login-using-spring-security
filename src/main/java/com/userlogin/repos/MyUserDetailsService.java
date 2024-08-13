package com.userlogin.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.userlogin.Service.UserPrincipal;
import com.userlogin.models.Users;
@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UsersRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user = this.repo.findByUsername(username);
		
		if(user == null) {
			System.out.println("user not found");
			throw new UsernameNotFoundException("user not found");
		}
		
		
		return new UserPrincipal(user);
	}

}
