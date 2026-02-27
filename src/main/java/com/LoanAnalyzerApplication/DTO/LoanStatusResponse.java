package com.LoanAnalyzerApplication.DTO;

import com.LoanAnalyzerApplication.entity.LoanStatus;
import com.LoanAnalyzerApplication.entity.RiskAnalyzer;

import lombok.Data;

@Data
public class LoanStatusResponse 
{
	private Integer loanId;
    private LoanStatus status;
   
	
	
}
