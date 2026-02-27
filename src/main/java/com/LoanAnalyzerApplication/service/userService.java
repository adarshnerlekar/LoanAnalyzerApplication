package com.LoanAnalyzerApplication.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LoanAnalyzerApplication.Repositry.UserRepository;
import com.LoanAnalyzerApplication.entity.user;

@Service
public class userService implements UserDetailsService
{
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<user> Username = userRepository.findByusername(username);
		if(Username.isPresent())
		{
			user user = Username.get();
			
			return User.withUsername(username)
					.password(user.getPassword())
					.roles(user.getRole().name())
					.build();
					
		}
		
		throw new UsernameNotFoundException("USER not found");
	}
}
