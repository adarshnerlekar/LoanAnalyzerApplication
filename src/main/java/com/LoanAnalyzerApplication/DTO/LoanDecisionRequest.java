package com.LoanAnalyzerApplication.DTO;

import lombok.Data;

@Data
public class LoanDecisionRequest 
{
	    private Integer loanId;
	    private String decision; // APPROVED or REJECTED
	    private String reason;
}
