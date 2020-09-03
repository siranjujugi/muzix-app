/**
 * 
 */
package com.stackroute.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author siranjeevi
 *
 */
public class RouterFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		return null;
	}

	@Override
	public String filterType() {
		System.out.println("Inside RouterFilter");
		return "router";
	}

	@Override
	public int filterOrder() {
		
		return 1;
	}

}
