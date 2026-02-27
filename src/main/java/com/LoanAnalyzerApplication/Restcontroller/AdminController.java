package com.LoanAnalyzerApplication.Restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoanAnalyzerApplication.Repositry.UserRepository;
import com.LoanAnalyzerApplication.entity.Role;
import com.LoanAnalyzerApplication.entity.user;

@RestController
public class AdminController 
{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	
	@PostMapping("createuser")
	public ResponseEntity<user> createuser(@RequestBody user user)
	{
		user.setRole(Role.CUSTOMER);
		user.setPassword(encoder.encode(user.getPassword()));
		com.LoanAnalyzerApplication.entity.user save = userRepository.save(user);
		return new ResponseEntity<user>(save, HttpStatus.CREATED);
	}
	

	@PostMapping("createLoanOfficer")
	public ResponseEntity<user> createLoanOfficer(@RequestBody user user)
	{
		user.setRole(Role.LOAN_OFFICER);
		user.setPassword(encoder.encode(user.getPassword()));
		user save = userRepository.save(user);
		return new ResponseEntity<user>(user,HttpStatus.CREATED);	
	}
	
	
}
