package com.LoanAnalyzerApplication.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.LoanAnalyzerApplication.service.userService;

@Configuration
@EnableWebSecurity
public class AppSecurity 
{
	@Autowired
	userService userService;
	@Autowired
	com.LoanAnalyzerApplication.service.JWTFIlter JWTFIlter;
	
	@Bean
	public BCryptPasswordEncoder encoder() 
	{
		return new BCryptPasswordEncoder();
	}
	
	@Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration
    ) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	@Bean
	public DaoAuthenticationProvider provider()
	{
		DaoAuthenticationProvider authentication=new DaoAuthenticationProvider(userService);
		authentication.setPasswordEncoder(encoder());
		return authentication;
	}
	
	@Bean
	public SecurityFilterChain createsecurity(HttpSecurity http)
	{
		http.csrf(csrf->csrf.disable());
		http.authenticationProvider(provider());
		http.authorizeHttpRequests(auth->{
			auth.requestMatchers("/createLoanOfficer").hasRole("ADMIN");
			auth.requestMatchers("/getAllLoans/{id}").hasRole("LOAN_OFFICER");
			auth.requestMatchers("/decision").hasRole("LOAN_OFFICER");
			auth.requestMatchers("/getAllLoans").hasRole("LOAN_OFFICER");
			auth.requestMatchers("/ApplyLoan").hasRole("CUSTOMER");
			auth.requestMatchers("/myloan").hasRole("CUSTOMER");
			auth.requestMatchers("/checkStatus").hasRole("CUSTOMER");
			auth.requestMatchers("/authenticate").permitAll();
			auth.requestMatchers("/createuser").permitAll();			
		}).httpBasic(Customizer.withDefaults()).formLogin(form->form.permitAll()).addFilterBefore(JWTFIlter,
                UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
	}
	

}
