package com.neosoft.springboot.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.neosoft.springboot.myexception.ResourceNotFoundException;

@Service
public class MyUserSecDetailService implements UserDetailsService {

	@Autowired
	UserSecRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Optional<UserSec> user=userRepository.findByUserName(userName);
		user.orElseThrow(()->new ResourceNotFoundException("UserSec", "UserName", userName));
		return user.map(MyUserSecDetail::new).get();
	}

}


//====================================================
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.neosoft.springboot.myexception.ResourceNotFoundException;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	UserRepository userRepository;
//	
//	@Override
//	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {		
//		Optional<User> user = userRepository.findByUserName(userName);
//		user.orElseThrow(() -> new ResourceNotFoundException("User", "UserName",userName));
//		return user.map(MyUserDetail::new).get();
//	}
//	
//}
