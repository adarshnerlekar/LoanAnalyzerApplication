package com.LoanAnalyzerApplication.Restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoanAnalyzerApplication.DTO.LoanStatusResponse;
import com.LoanAnalyzerApplication.entity.LoanApplication;
import com.LoanAnalyzerApplication.entity.user;
import com.LoanAnalyzerApplication.service.LoanService;

@RestController
public class LoanController 
{
	@Autowired
	LoanService LoanService;
	
	
	
	
	
	@GetMapping("checkStatus")
	public ResponseEntity<LoanStatusResponse> checkstatus( Authentication authentication)
	{
		String username = authentication.getName();
		LoanStatusResponse loanStatus = LoanService.getLoanStatus(username);
		return new ResponseEntity<LoanStatusResponse>(loanStatus,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("ApplyLoan")
	public ResponseEntity<LoanApplication> ApplyLoan(@RequestBody LoanApplication loan)
	{
		LoanApplication save = LoanService.getloan(loan);
		return new ResponseEntity<LoanApplication>(save,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("myloan")
	public ResponseEntity<List<LoanApplication>> myloan()
	{
		List<LoanApplication> getmyloan = LoanService.getmyloan();
		return new ResponseEntity<List<LoanApplication>>(getmyloan,HttpStatus.ACCEPTED);
	}
	
}
