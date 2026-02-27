package com.LoanAnalyzerApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanApplication 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int age;
	
	private Double loanAmount;
	
	private Double income;
	
	private Double creditScore;
	
	@Enumerated(EnumType.STRING)
	private LoanStatus status;
	
	@Enumerated(EnumType.STRING)
	private RiskAnalyzer riskLevel;
	
	private String reason;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private user user;

}
