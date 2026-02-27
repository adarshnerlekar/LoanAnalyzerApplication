package com.LoanAnalyzerApplication.Restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LoanAnalyzerApplication.DTO.LoanDecisionRequest;
import com.LoanAnalyzerApplication.entity.LoanApplication;
import com.LoanAnalyzerApplication.service.LoanService;

@RestController
public class LoanOfficerController 
{
	@Autowired
    private LoanService loanService;
	
	
	@GetMapping("getAllLoans/{id}")
	public ResponseEntity<LoanApplication> getloanByID(@PathVariable Integer id)
	{
		LoanApplication loanById = loanService.getLoanById(id);
		return new ResponseEntity<LoanApplication>(loanById,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("getAllLoans")
	public ResponseEntity<List<LoanApplication>> getAllLoan()
	{
		List<LoanApplication> getall = loanService.getallLoans();
		return new ResponseEntity<List<LoanApplication>>(getall,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("decision")
    public String approveOrRejectLoan(@RequestBody LoanDecisionRequest request) 
	{

 loanService.processLoanDecision(request.getLoanId(), request.getDecision(),request.getReason());

        return "Loan decision updated successfully";
    }
}
