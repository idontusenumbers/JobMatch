package com.jobmatch.controllers;

import com.github.javafaker.Faker;
import com.jobmatch.models.Education;
import com.jobmatch.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    @RequestMapping("")
    public String index(Model context) {
        context.addAttribute("title", "Users");
        context.addAttribute("users", userRepository.findAll());

        return "users/index";
    }

    /**
     * Adds Random Education to user (for now)
     *
     * @param userId
     * @return
     */
    @RequestMapping("/addEducation/{userId}")
    public String addEducation(@PathVariable Integer userId) {
        Faker faker = new Faker(Locale.ENGLISH);

        try {
            User user = userRepository.findOne(userId);
            Education education = new Education(
                    faker.company().name(),
                    faker.country().name(),
                    faker.lorem().word(),
                    faker.lorem().word(),
                    faker.date().past(365, TimeUnit.DAYS).getYear()
            );
            user.getEducation().add(education);
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return "users/education";
    }
}