package com.tejesh.teamflow.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long taskId;
	private String title;
	private String description;
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	@ManyToOne
	@JoinColumn(name="created_by")
	private User createdBy;
	private LocalDateTime createdAt;
}
