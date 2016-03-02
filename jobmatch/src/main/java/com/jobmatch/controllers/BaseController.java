package com.jobmatch.controllers;

import com.jobmatch.models.Role;
import com.jobmatch.models.User;
import com.jobmatch.repositories.ContactRepository;
import com.jobmatch.repositories.CultureRepository;
import com.jobmatch.repositories.EducationRepository;
import com.jobmatch.repositories.JobPostRepository;
import com.jobmatch.repositories.RankedSkillRepository;
import com.jobmatch.repositories.RoleRepository;
import com.jobmatch.repositories.SkillRepository;
import com.jobmatch.repositories.UserRepository;
import com.jobmatch.services.UserRepositoryUserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;


@Controller
public class BaseController extends WebMvcConfigurerAdapter {
    protected static final Logger log = LoggerFactory.getLogger(BaseController.class);
    @Autowired
    protected UserRepository userRepository;
    @Autowired
    protected ContactRepository contactRepository;
    @Autowired
    protected RoleRepository roleRepository;
    @Autowired
    protected SkillRepository skillRepository;

    @Autowired
    protected CultureRepository cultureRepository;
    @Autowired
    protected EducationRepository educationRepository;
    @Autowired
    protected JobPostRepository jobPostRepository;

    @Autowired
    protected RankedSkillRepository rankedSkillRepository;

    @Autowired
    protected FreeMarkerViewResolver viewResolver;
    @Autowired
    protected HttpServletRequest context;
    @Autowired
    protected HttpSession session;

    static View getRedirectView(String url) {
        RedirectView redirect = new RedirectView(url);
        redirect.setExposeModelAttributes(false);
        return redirect;
    }

    protected View getView(String viewName) {
        try {
            return viewResolver.resolveViewName(viewName, Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @ModelAttribute
    public void addToModel(Model model) {

        model.addAttribute("auth", getAuth());
        model.addAttribute("currentUser", getCurrentUser());
    }


    public Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public User getCurrentUser() {
        Object principal = getAuth().getPrincipal();
        if (principal instanceof UserRepositoryUserDetails)
            return userRepository.findOne(((UserRepositoryUserDetails) principal).getUser().getId());
        else
            return null;
    }


    protected void enforceSameUserUnlessAdmin(@ModelAttribute User user) {
        User currentUser = getCurrentUser();

        switch (currentUser.getRole().getId()) {
            case Role.SEEKER:
            case Role.EMPLOYER:
                if (currentUser.getId() != user.getId())
                    throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
    }
    protected void enforceSameUserUnlessAdmin(int userId) {
        enforceSameUserUnlessAdmin(userRepository.findOne(userId));
    }

    protected void enforceSameUserOrEmployer(@ModelAttribute User user) {
        User currentUser = getCurrentUser();

        switch (currentUser.getRole().getId()) {
            case Role.SEEKER:
                if (currentUser.getId() != user.getId())
                    throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
        }
    }
        protected void enforceSameUserOrEmployer(int userId) {
        enforceSameUserOrEmployer(userRepository.findOne(userId));
    }
}
