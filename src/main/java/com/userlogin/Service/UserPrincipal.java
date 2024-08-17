package com.userlogin.Service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.userlogin.models.Users;

public class UserPrincipal implements UserDetails{

	Users user;
	
	
	public UserPrincipal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserPrincipal(Users user) {
		super();
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	return 	Collections.singleton(new SimpleGrantedAuthority("USER"));
		
	}

	@Override
	public String getPassword() {
		
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}
	
	public Users getFullUser() {
		return this.user;
	}
}
