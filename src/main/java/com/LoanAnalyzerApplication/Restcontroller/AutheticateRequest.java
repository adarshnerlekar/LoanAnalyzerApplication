package com.LoanAnalyzerApplication.Restcontroller;

import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@Data
@RestController
public class AutheticateRequest 
{
    private String username;
	
	private String password;  

}
