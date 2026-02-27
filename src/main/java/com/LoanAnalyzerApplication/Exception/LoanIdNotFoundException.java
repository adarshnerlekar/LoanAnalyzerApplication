package com.LoanAnalyzerApplication.Exception;

public class LoanIdNotFoundException extends RuntimeException 
{
	public LoanIdNotFoundException(String msg) 
	{
		super(msg);
	}
}
