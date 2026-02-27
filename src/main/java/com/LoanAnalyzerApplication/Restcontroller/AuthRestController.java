package com.LoanAnalyzerApplication.Restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoanAnalyzerApplication.service.userService;
import com.example.SpringJWT5.Rest.AutheticateRequest;


@RestController
public class AuthRestController 
{
	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private userService userDetailsService;

	@Autowired
	private com.LoanAnalyzerApplication.service.JWTUtil JWTUtil;

	@PostMapping("authenticate")
	public String authenticate(@RequestBody AutheticateRequest request) throws Exception {

		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		} catch (Exception e) {
			throw new Exception("Invalid Username or Password");
		}

		org.springframework.security.core.userdetails.UserDetails user = ( (UserDetailsService) userDetailsService).loadUserByUsername(request.getUsername());

		String token = JWTUtil.generateToken(user);

		return token;

	}

}
