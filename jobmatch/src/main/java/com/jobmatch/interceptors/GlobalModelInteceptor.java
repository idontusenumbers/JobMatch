package com.jobmatch.interceptors;

import com.jobmatch.Application;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// From http://stackoverflow.com/questions/31500935/spring-add-session-attribute-in-every-controller-model

@Service
public class GlobalModelInteceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
																									   Exception {
		return super.preHandle(request, response, handler);

	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

		if (modelAndView != null) {
			modelAndView.getModelMap().mergeAttributes(Application.getGlobalContext());
		}
	}
}