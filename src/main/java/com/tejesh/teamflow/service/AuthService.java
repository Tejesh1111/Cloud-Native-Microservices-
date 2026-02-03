package com.tejesh.teamflow.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tejesh.teamflow.dto.SignupRequest;
import com.tejesh.teamflow.entity.Company;
import com.tejesh.teamflow.entity.Role;
import com.tejesh.teamflow.entity.User;
import com.tejesh.teamflow.repository.CompanyRepository;
import com.tejesh.teamflow.repository.UserRepository;
import com.tejesh.teamflow.security.JwtUtil;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository,
                       CompanyRepository companyRepository,
                       PasswordEncoder passwordEncoder,JwtUtil jwtUtil) {
        this.userRepository=userRepository;
        this.companyRepository=companyRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtil=jwtUtil;
    }

    public void register(SignupRequest request) {

        Company company=new Company();
        company.setName(request.getCompanyName());
        Company savedCompany=companyRepository.save(company);

        User user=new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ADMIN);
        user.setCompany(savedCompany);

        userRepository.save(user);
    }
    
    public String login(String email,String password)
    {
    	User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("user not found"));
    	if(!passwordEncoder.matches(password, user.getPassword())) {
    		throw new RuntimeException("Invalid credentials");
    	}
    	
    	return jwtUtil.generateToken(user.getUserId(),user.getRole().name(),user.getCompany().getComapnyId());
    }
}
