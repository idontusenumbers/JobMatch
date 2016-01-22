package com.jobmatch.controllers;

import com.jobmatch.models.User;
import com.jobmatch.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    private final UserRepository userRepository;

    @Autowired
    IndexController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/")
    public String index() {

        log.info("=== All Users ===");
        log.info("-----------------");

        StringBuilder response = new StringBuilder();
        response.append("List of all users: <p>\n");

        for (User user : userRepository.findAll()) {
            log.info(user.toString());
            response.append(user.toString() + "<br />\n");
        }

        return response.toString();
    }

    @RequestMapping("/create")
    public String create() {
        int userNum = Long.valueOf(userRepository.count()).intValue();

        User user = userRepository.save(new User(1, "user" + Integer.valueOf(userNum + 1).toString(), "letmein", false));

        return user.toString();
    }
}