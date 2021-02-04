package com.webwork.jwtauthdemo.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.webwork.jwtauthdemo.service.impl.CustomUserDetailService;
import com.webwork.jwtauthdemo.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;
	
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authorizationHeader = request.getHeader("Authorization");

		System.out.println("===> Authorized : "+authorizationHeader);
		String token = null;
		String userName = null;

//		if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
//			token = authorizationHeader.substring(7);
//			//trace token
//			System.out.println("\n ====> This Function is Called");
//			logger.warn(token);
//			userName = jwtUtil.extractUsername(token);
//		}
//		
		
		if (authorizationHeader != null) {
			//token = authorizationHeader.substring(7);
			//trace token
			System.out.println("\n ====> This Function is Called");
			logger.warn(authorizationHeader);
			userName = jwtUtil.extractUsername(authorizationHeader);
			
			System.out.println("\n ====> Username"+userName);
			
			
		}
		
		
	

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userDetails = customUserDetailService.loadUserByUsername(userName);
			
			System.out.println("====>"+ userDetails.getUsername()+"\n ====>"+ authorizationHeader);

			if (jwtUtil.validateToken(authorizationHeader, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}

		}
		filterChain.doFilter(request, response);

	}

}
