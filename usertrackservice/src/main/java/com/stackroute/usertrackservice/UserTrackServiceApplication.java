package com.stackroute.usertrackservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//import com.stackroute.usertrackservice.filter.JwtFilter;

@SpringBootApplication
@EnableEurekaClient
public class UserTrackServiceApplication {
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
	
//	@Bean
//	public FilterRegistrationBean<GenericFilterBean> registerFilter(){
//		final FilterRegistrationBean<GenericFilterBean> filterBean = new FilterRegistrationBean<GenericFilterBean>();		
//		filterBean.setFilter(new JwtFilter());
//		filterBean.addUrlPatterns("/api/v1/usertrackservice/user/*");
//		return filterBean;
//		
//	}

	public static void main(String[] args) {
		SpringApplication.run(UserTrackServiceApplication.class, args);
	}

}
