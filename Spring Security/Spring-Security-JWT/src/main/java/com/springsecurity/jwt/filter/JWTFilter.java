package com.springsecurity.jwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springsecurity.jwt.service.CustomUserDetailService;
import com.springsecurity.jwt.util.JWTUtil;

@Component
public class JWTFilter extends OncePerRequestFilter{
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private CustomUserDetailService service;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain) throws ServletException, IOException {
		String authorizationHeader = request.getHeader("Authorization");
		String userName=null, token=null;
		// Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyMSIsImV4cCI6MTYzMTM3ODcyOSwiaWF0IjoxNjMxMzQyNzI5fQ.KHyuYPytWyfcQEDF-R5U0iiqT9RV_bMgu_cHhC18lEE
		if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer")) {
			token = authorizationHeader.substring(7);
			System.out.println("token --------------> " +token);
			userName = jwtUtil.extractUsername(token);
		}
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = service.loadUserByUsername(userName);
			if(jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken userPwdToken = new UsernamePasswordAuthenticationToken
						(userDetails, null, userDetails.getAuthorities());
				userPwdToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				System.out.println("userPwdToken -----------> " + userPwdToken);
				SecurityContextHolder.getContext().setAuthentication(userPwdToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
