package com.jobmatch.controllers;

import com.jobmatch.models.User;
import com.jobmatch.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    @Autowired
    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping("/")
    public String users(Map<String, Object> model) {

        log.info("=== users ===");


        model.put("users", userRepository.findAll());
        model.put("title", "Users");
		return "users/users";

    }

    @RequestMapping("/create")
    public String create() {
        int userNum = Long.valueOf(userRepository.count()).intValue();

        User user = userRepository.save(new User(1, "user" + Integer.valueOf(userNum + 1).toString(), "letmein", false));

        return user.toString();
    }
}