package com.tejesh.teamflow.security;

public class AuthUser {
	private Long userId;
	private Long companyId;
	private String role;
	public AuthUser(Long userId,Long companyId,String role)
	{
		this.userId=userId;
		this.companyId=companyId;
		this.role=role;
	}
	public Long getUserId()
	{
		return userId;
	}
	public Long getCompanyId()
	{
		return companyId;
	}
	public String getRole()
	{
		return role;
	}
	
}
