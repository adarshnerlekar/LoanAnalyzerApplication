package com.LoanAnalyzerApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.LoanAnalyzerApplication.Repositry.UserRepository;
import com.LoanAnalyzerApplication.entity.Role;
import com.LoanAnalyzerApplication.entity.user;

import jakarta.annotation.PostConstruct;

@Component
public class AdminInitializer 
{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@PostConstruct
	public void createAdminIfNotExists() 	
	{
		if(userRepository.findByusername("admin").isEmpty())
		{
			user admin=new user();
			admin.setUsername("admin");
			admin.setPassword(encoder.encode("admin123"));
			admin.setRole(Role.ADMIN);
			userRepository.save(admin);
		}
	}
}
