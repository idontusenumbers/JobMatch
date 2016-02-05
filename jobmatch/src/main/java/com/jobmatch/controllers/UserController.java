package com.jobmatch.controllers;

import com.jobmatch.models.Contact;
import com.jobmatch.models.Education;
import com.jobmatch.models.User;
import com.jobmatch.models.UserSkill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    @RequestMapping("")
    public String list(Map<String, Object> context) {
        context.put("title", "Users");
        context.put("users", userRepository.findAll());


		return "users/list";

    }

    @RequestMapping("/create")
    public String create(Map<String, Object> context, boolean optIn, String username, String password, String roleName) {
        context.put("title", "Users");
        context.put("users", userRepository.findAll());

        User user = new User();
        user.setRole(roleRepository.findByName(roleName));
        user.setOptIn(optIn);
        user.setPassword(password);
        user.setUsername(username);
//        user.setContact(new Contact("email", "1234567", "address", "", "", "", ""));
//

//        Set<UserSkill> skills = new HashSet<>();
//        skills.add(new UserSkill(skillRepository.findByName("C++"), 10));
//        skills.add(new UserSkill(skillRepository.findByName("Java"), 8));

//        user.getSkills().addAll(skills);

        userRepository.save(user);

        return "user/index";
    }

    @RequestMapping("/addEducation")
    public String addEducation(Map<String, Object> context,
                               Integer userId, String degree, String schoolName, String country, String major, int year){

        User user = userRepository.findOne(userId);
        user.getEducation().add(new Education(schoolName, country, degree, major, year));
        userRepository.save(user);
        return "user/education";
    }



}