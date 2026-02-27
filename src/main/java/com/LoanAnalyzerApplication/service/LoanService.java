package com.LoanAnalyzerApplication.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.LoanAnalyzerApplication.DTO.LoanStatusResponse;
import com.LoanAnalyzerApplication.Exception.LoanIdNotFoundException;
import com.LoanAnalyzerApplication.Repositry.LoanRepositry;
import com.LoanAnalyzerApplication.Repositry.UserRepository;
import com.LoanAnalyzerApplication.entity.LoanApplication;
import com.LoanAnalyzerApplication.entity.LoanStatus;
import com.LoanAnalyzerApplication.entity.RiskAnalyzer;
import com.LoanAnalyzerApplication.entity.user;

@Service
public class LoanService 
{	
	@Autowired
	LoanRepositry LoanRepositry;
	
	@Autowired
	UserRepository userRepositry;
	
	public LoanApplication getLoanById(Integer id)
	{
		Optional<LoanApplication> byId = LoanRepositry.findById(id);
		if(byId.isPresent())
		{
			LoanApplication loanApplication = byId.get();
			return loanApplication;
			
		}
		throw new LoanIdNotFoundException("loanApplication ID Not Found :"+id);
	}
	
	public List<LoanApplication> getallLoans()
	{
		List<LoanApplication> all = LoanRepositry.findAll();
		return all;
	}
	
	
	
	
	public void processLoanDecision( Integer loanId, String decision,String reason) 
	{

	    LoanApplication loan =
	    		LoanRepositry.findById(loanId)
	        .orElseThrow(() -> new RuntimeException("Loan not found"));

	    if ("APPROVED".equalsIgnoreCase(decision)) 
	    {
	        loan.setStatus(LoanStatus.APPROVED);
	        loan.setReason("Loan approved");
	    }
	    else if ("REJECTED".equalsIgnoreCase(decision)) 
	    {
	        loan.setStatus(LoanStatus.REJECTED);
	        loan.setReason(reason);
	    }
	    else 
	    {
	        throw new RuntimeException("Invalid decision");
	    }

	    LoanRepositry.save(loan);
	}
	
	
	public LoanStatusResponse getLoanStatus(String username) {

        LoanApplication loan = LoanRepositry
                .findTopByUserUsernameOrderByIdDesc(username)
                .orElseThrow(() -> new RuntimeException("No loan found for this user"));
        	 
        LoanStatusResponse response = new LoanStatusResponse();
        
        response.setLoanId(loan.getId());
        response.setStatus(loan.getStatus());
       
        return response;
    }

	public List<LoanApplication> getmyloan()
	{
		 @Nullable
		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 String username = authentication.getName();
	     user cureentuser = userRepositry.findByusername(username).get();  
	     return LoanRepositry.findByuser(cureentuser);
	}
	
	
	public  LoanApplication getloan(LoanApplication loanapp )
	{
		
		
		@Nullable
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String name = authentication.getName();
		 user currentuser = userRepositry.findByusername(name).get();
		 
		 
		 if (currentuser == null)
		 {
			    throw new RuntimeException("User not found");
			}
		 loanapp.setUser(currentuser);
		loanapp.setStatus(LoanStatus.PENDING);
		
		//🧠 Risk logic
        if (loanapp.getIncome() < 15000 || loanapp.getCreditScore() < 500) 
        {
            loanapp.setRiskLevel(RiskAnalyzer.HIGH_RISK);
            loanapp.setReason("Low income or credit score");
        }
        else if (loanapp.getIncome() >= 15000 && loanapp.getIncome() < 30000
                 && loanapp.getCreditScore() >= 650) 
        {
            loanapp.setRiskLevel(RiskAnalyzer.MEDIUM_RISK);
            loanapp.setReason("Average profile");
        }
        else if (loanapp.getIncome() >= 30000 && loanapp.getCreditScore() >= 750)
        {
            loanapp.setRiskLevel(RiskAnalyzer.LOW_RISK);
            loanapp.setReason("Good income and credit score");
        }
        return LoanRepositry.save(loanapp);
	}




	
}