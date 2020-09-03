/**
 * 
 */
package com.stackroute.zuulservice.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;

/**
 * @author siranjeevi
 *
 */
public class JwtFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;
		final String authHeader = httpRequest.getHeader("authorization");
		if ("OPTIONS".equals(httpRequest.getMethod())) {
			httpResponse.setStatus(HttpServletResponse.SC_OK);
			chain.doFilter(httpRequest, httpResponse);
		} else {
			
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				throw new ServletException("Missing or invalid authorization header");
			}
			
			final String token = authHeader.substring(7);
			final Claims claim = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody();
			request.setAttribute("claims", claim);
			chain.doFilter(httpRequest, httpResponse);
			
		}
		
		
	}

}
