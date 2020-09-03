/**
 * 
 */
package com.stackroute.zuulservice.filter;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author siranjeevi
 *
 */
public class PostFilter extends ZuulFilter { 

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		System.out.println("Response");
		return null;
	}

	@Override
	public String filterType() {
		System.out.println("Inside PreFilter");
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}
}
