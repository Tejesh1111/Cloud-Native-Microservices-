package com.tejesh.teamflow.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
	private final Key key=Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private final long EXPIRATION_TIME=1000*60*60;
	public String generateToken(Long userId,String role,Long companyId)
	{
		return Jwts.builder()
				.setSubject(userId.toString())
				.claim("role", role)
				.claim("comapnyId", companyId)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
				.signWith(key)
				.compact();
	}
	public Claims validateToken(String token)
	{
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
}
