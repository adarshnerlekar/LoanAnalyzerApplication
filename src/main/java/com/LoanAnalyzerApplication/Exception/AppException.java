package com.LoanAnalyzerApplication.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppException 
{
	@ExceptionHandler
	public ResponseEntity<error> Exception(Exception e)
	{
		error er=new error();
		er.setMsg(er.getMsg());
		er.setDatetime(LocalDateTime.now());
		
		return new ResponseEntity<error>(er,HttpStatus.BAD_REQUEST);

	}
   
}
