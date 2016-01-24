package com.jobmatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {FreeMarkerAutoConfiguration.class})
public class Application extends WebMvcConfigurerAdapter {

	public static final String TITLE = "JobMatch";
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Application.class, args);
	}


	public static Map<String, Object> getGlobalContext(){
		Map<String, Object> result = new HashMap<>();

		result.put("title", Application.TITLE); // Base template references title so it must be defined. Actions can override.

		return result;
	}

}