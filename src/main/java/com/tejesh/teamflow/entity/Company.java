package com.tejesh.teamflow.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name="companies")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long companyId;
	private String name;
	private LocalDateTime createdAt;
	public Long getComapnyId() {
		return companyId;
	}
	public void setComapnyId(Long comapnyId) {
		this.companyId = comapnyId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}
