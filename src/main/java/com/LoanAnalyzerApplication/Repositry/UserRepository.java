package com.LoanAnalyzerApplication.Repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LoanAnalyzerApplication.entity.user;

@Repository
public interface UserRepository extends JpaRepository<user, Integer>
{
	Optional<user>findByusername(String username);

}
