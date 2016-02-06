package com.jobmatch.controllers;

import com.jobmatch.models.User;
import com.jobmatch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@Controller
public class IndexController extends BaseController{


    @RequestMapping("/")
    public String index(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

		return "index";

    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Map<String, Object> model, String error) {
        if (error != null)
            model.put("errors", Arrays.asList("Unknown user or password"));

        return "index";

    }

    @RequestMapping("/register")
    public String getRegisterForm(Model model) {
        model.addAttribute("user", new User());

        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

        // TODO: Implement Validator
        // TODO: Add Selection for account type
        user.setRole(roleRepository.findByName("student"));
        userRepository.save(user);

        return "redirect:index";
    }

}