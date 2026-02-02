package com.tejesh.teamflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tejesh.teamflow.entity.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompany_CompanyId(Long companyId);
}
