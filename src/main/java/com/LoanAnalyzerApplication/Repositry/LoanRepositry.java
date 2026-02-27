package com.LoanAnalyzerApplication.Repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LoanAnalyzerApplication.entity.LoanApplication;
import com.LoanAnalyzerApplication.entity.user;

@Repository
public interface LoanRepositry extends JpaRepository<LoanApplication , Integer>
{
	List<LoanApplication>findByuser(user cureentuser);
	
	Optional<LoanApplication> findTopByUserUsernameOrderByIdDesc(String username);
	
	
}
