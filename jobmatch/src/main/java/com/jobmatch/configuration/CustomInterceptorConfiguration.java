package com.jobmatch.configuration;

import com.jobmatch.interceptors.GlobalModelInteceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomInterceptorConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	GlobalModelInteceptor globalModHandlerInterceptor;


	public HandlerInterceptor getGlobalModHandlerInterceptor() {
		return globalModHandlerInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getGlobalModHandlerInterceptor());
	}
}
