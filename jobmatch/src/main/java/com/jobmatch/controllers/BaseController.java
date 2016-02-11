package com.jobmatch.controllers;

import com.jobmatch.models.User;
import com.jobmatch.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BaseController {
	protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

	Authentication auth;

	public Authentication getAuth() {
		if (auth == null)
			auth = SecurityContextHolder.getContext().getAuthentication();
		return auth;
	}
	public User getCurrentUser(){
		return (User) getAuth().getPrincipal();
	}

	@ModelAttribute
    public void addAuthToModel(Model model) {
		model.addAttribute("auth", getAuth());
	}

	@Autowired
	private HttpServletRequest context;
	@Autowired
	private HttpSession session;

	@Autowired
	protected UserRepository userRepository;
	@Autowired
	protected RoleRepository roleRepository;
	@Autowired
	protected SkillRepository skillRepository;
	@Autowired
	protected EducationRepository educationRepository;
	@Autowired
	protected JobPostRepository jobPostRepository;
}
