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
public class PreFilter extends ZuulFilter { 

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext reqContext = new RequestContext();
		HttpServletRequest request = reqContext.getRequest();
		if (request != null ) { System.out.println("Request method : " + request.getMethod());
		System.out.println("Request url : " + request.getRequestURL());
		}
		return null;
	}

	@Override
	public String filterType() {
		System.out.println("Inside PreFilter");
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}


}
