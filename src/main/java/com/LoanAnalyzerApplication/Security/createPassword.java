package com.LoanAnalyzerApplication.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class createPassword {

	public static void main(String[] args) 
	{
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String rawPassword="1212";
		String EncoderPassword=encoder.encode(rawPassword);
		System.out.println(EncoderPassword);
	}

}
