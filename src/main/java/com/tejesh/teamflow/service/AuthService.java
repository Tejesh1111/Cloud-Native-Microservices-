package com.tejesh.teamflow.service;

import com.tejesh.teamflow.dto.SignupRequest;
import com.tejesh.teamflow.entity.Company;
import com.tejesh.teamflow.entity.Role;
import com.tejesh.teamflow.entity.User;
import com.tejesh.teamflow.repository.CompanyRepository;
import com.tejesh.teamflow.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       CompanyRepository companyRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository=userRepository;
        this.companyRepository=companyRepository;
        this.passwordEncoder=passwordEncoder;
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
    

}
