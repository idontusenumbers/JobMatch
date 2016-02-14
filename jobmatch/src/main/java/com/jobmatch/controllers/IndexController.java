package com.jobmatch.controllers;

import com.jobmatch.configuration.SecurityConfiguration;
import com.jobmatch.models.Role;
import com.jobmatch.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController extends BaseController {


    @RequestMapping("/")
    public String index(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error) {
        if (error != null)
            model.addAttribute("errors", Arrays.asList("Unknown user or password"));

        return "index";
    }

    @RequestMapping("/register")
    public String getRegisterForm(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

        /*
         * Populate radio buttons dynamically from the database for account role.
         * Exclude Admin role for obvious reasons.
         */
        Map<String, String> roles = new HashMap<>();
        List<Role> roleList = (List<Role>) roleRepository.findAll();
        roleList.remove(0);
        for (Role role : roleList) {
            roles.put(String.valueOf(role.getId()), role.getName());
        }

        model.addAttribute("roleMap", roles);

        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister(@ModelAttribute @Valid User user, BindingResult result, Model model  ) {

        if (user.getRole().getId() == Role.ADMIN)
            result.addError(new ObjectError("role", "You cannot create an admin"));
        if (userRepository.findByUsername(user.getUsername()) != null)
            result.addError(new FieldError("user", "username", "Username already taken"));
        if (!user.getOptIn())
            result.addError(new FieldError("user", "optIn", "You must opt in"));


        if (result.hasErrors()) {
            return "register";
        } else {
            userRepository.save(user);
            SecurityConfiguration.loginUser(user);
            return "redirect:/home";
        }

    }


}