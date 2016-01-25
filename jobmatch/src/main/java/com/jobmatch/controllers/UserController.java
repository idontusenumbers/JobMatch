package com.jobmatch.controllers;

import com.jobmatch.models.Contact;
import com.jobmatch.models.Education;
import com.jobmatch.models.User;
import com.jobmatch.models.UserSkill;
import com.jobmatch.repositories.EducationRepository;
import com.jobmatch.repositories.RoleRepository;
import com.jobmatch.repositories.SkillRepository;
import com.jobmatch.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private EducationRepository educationRepository;
    @Autowired
    private SkillRepository skillRepository;

    @RequestMapping("")
    public String users(Map<String, Object> model) {

        log.info("=== users ===");


        model.put("users", userRepository.findAll());
        model.put("title", "Users");
		return "users/index";

    }

    @RequestMapping("/create")
    public String create(Map<String, Object> model) {
        model.put("users", userRepository.findAll());
        model.put("title", "Users");

        User user = new User();
        user.setRole(roleRepository.findByRoleName("company"));
        user.setOpt_in(true);
        user.setPassword("password");
        user.setUsername("epfeiffer");
        user.setContact(new Contact("email", "1234567", "address", "", "", "", ""));

        Set<Education> educationSet = new HashSet<Education>();
        educationSet.add(new Education("DePaul University", "US", "BS", "Computer Science", 2016));
        user.setEducation(educationSet);

        Set<UserSkill> skills = new HashSet<>();
        skills.add(new UserSkill(skillRepository.findByName("C++"), 10));
        skills.add(new UserSkill(skillRepository.findByName("Java"), 8));

        user.setSkills(skills);

        userRepository.save(user);

        return "users/index";
    }
}