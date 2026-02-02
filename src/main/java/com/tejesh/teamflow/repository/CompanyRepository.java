package com.tejesh.teamflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tejesh.teamflow.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
