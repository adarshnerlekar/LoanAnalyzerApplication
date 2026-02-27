package com.LoanAnalyzerApplication.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class error {
	
	String msg;
	LocalDateTime datetime;

}
