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
import org.springframework.web.servlet.View;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class IndexController extends BaseController {

    @RequestMapping("/")
    public String index() {
        if (getCurrentUser() != null)
            return "forward:/jobs/";
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
        // TODO prevent logged in users from registering

        model.addAttribute("user", user);

        /*
         * Populate radio buttons dynamically from the database for account role.
         * Exclude Admin role for obvious reasons.
         */

        Map<String, String> roles = StreamSupport.stream(roleRepository.findAll().spliterator(), false)
                .filter(role -> role.getId() != Role.ADMIN)
                .collect(Collectors.toMap(role -> String.valueOf(role.getId()), Role::getName));

        model.addAttribute("roleMap", roles);

        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public View postRegister(@ModelAttribute @Valid User user, BindingResult result, Model model) {
        // TODO prevent logged in users from registering

        if (user.getRole().getId() == Role.ADMIN)
            result.addError(new ObjectError("role", "You cannot create an admin"));
        if (userRepository.findByUsername(user.getUsername()) != null)
            result.addError(new FieldError("user", "username", "Username already taken"));
        if (!user.getOptIn())
            result.addError(new FieldError("user", "optIn", "You must opt in"));


        if (result.hasErrors()) {
            return  getView(getRegisterForm(user, model));
        } else {
            userRepository.save(user);
            SecurityConfiguration.loginUser(user);
            return getRedirectView("/users/" + user.getId() + "/profile");
        }
    }
}