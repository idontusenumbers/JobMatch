package com.jobmatch.controllers;

import com.jobmatch.models.Role;
import com.jobmatch.models.User;
import com.jobmatch.repositories.*;
import com.jobmatch.services.UserRepositoryUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.HttpClientErrorException;
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


    @ModelAttribute
    public void addAuthToModel(Model model) {
        model.addAttribute("auth", getAuth());
    }

    public Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public User getCurrentUser() {
        Object principal = getAuth().getPrincipal();
        if (principal instanceof  UserRepositoryUserDetails)
            return ((UserRepositoryUserDetails) principal).getUser();
        else
            return null;
    }


    protected void enforceSameUserUnlessAdmin(@ModelAttribute User user) {
        User currentUser = getCurrentUser();

        switch (currentUser.getRole().getId()) {
            case Role.STUDENT:
            case Role.EMPLOYER:
                if (currentUser.getId() != user.getId())
                    throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
    }
    protected void enforceSameUserUnlessAdmin(int userId) {
        enforceSameUserUnlessAdmin(userRepository.findOne(userId));
    }
}
