package com.neosoft.springboot.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserSecDetail implements UserDetails{

	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;
	
	 public MyUserSecDetail(UserSec user) {
		this.userName=user.getUserName();
		this.password=user.getPassword();
		this.active=user.isActive();
		this.authorities=Arrays.stream(user.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return active;
	}

	
}


//=========================================================


//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//public class MyUserDetail implements UserDetails {
//	
//	private String userName;
//	private String password;
//	private boolean active;	
//	private List<GrantedAuthority> authorities;
//	
//	public MyUserDetail(User user) {
//		this.userName=user.getUserName();
//		this.password=user.getPassword();
//		this.active=user.isActive();
//		this.authorities=Arrays.stream(user.getRoles().split(","))
//				.map(SimpleGrantedAuthority::new)
//				.collect(Collectors.toList());
//	}
//	
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {		
//		return authorities;
//	}
//
//	@Override
//	public String getPassword() {
//		return password;
//	}
//
//	@Override
//	public String getUsername() {		
//		return userName;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {		
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {		
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {		
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {		
//		return active;
//	}
//
//}
