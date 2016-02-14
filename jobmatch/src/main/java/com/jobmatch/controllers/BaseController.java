package com.jobmatch.controllers;

import com.jobmatch.models.User;
import com.jobmatch.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class BaseController extends WebMvcConfigurerAdapter {
    protected static final Logger log = LoggerFactory.getLogger(BaseController.class);
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
    @Autowired
    protected HttpServletRequest context;
    @Autowired
    protected HttpSession session;




    Authentication auth;

    public Authentication getAuth() {

        auth = SecurityContextHolder.getContext().getAuthentication();
        return auth;
    }

    public User getCurrentUser() {
        return (User) getAuth().getPrincipal();
    }

    @ModelAttribute
    public void addAuthToModel(Model model) {
        model.addAttribute("auth", getAuth());
    }
}
