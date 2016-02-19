package com.jobmatch.controllers;

import com.github.javafaker.Faker;
import com.jobmatch.models.Education;
import com.jobmatch.models.Role;
import com.jobmatch.models.User;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;

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


    @RequestMapping(value = "{userId}/profile", method = RequestMethod.GET)
    public String getProfile(@PathVariable int userId, Model model) {
        User user = userRepository.findOne(userId);
        enforceSameUserUnlessAdmin(user);
        model.addAttribute("user", user);
        switch (user.getRole().getId()) {
            case Role.ADMIN:
            case Role.STUDENT:
                return "users/profile-student";
            case Role.EMPLOYER:
                return "users/profile-employer";
            default:
                throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "{userId}/profile", method = RequestMethod.POST)
    public String putProfile(@PathVariable int userId, @ModelAttribute User updatedUser, Model model) {
        enforceSameUserUnlessAdmin(userId);

        BeanUtils.copyProperties(updatedUser, user, "id", "username", "password", "role", "optIn");
        userRepository.save(user);

        return "redirect:/home";
    }


    @RequestMapping(value = "{userId}/delete")
    public String delete(@PathVariable int userId, Model model) {
        User user = userRepository.findOne(userId);
        enforceSameUserUnlessAdmin(user);

        userRepository.delete(user.getId());

        if (getCurrentUser().getRole().getId() == Role.ADMIN) {
            return "redirect:../";
        } else {
            return "redirect:/logout";
        }
    }

    /**
     * Adds Random Education to user (for now)
     *
     * @param userId
     * @return
     */
    @RequestMapping("{userId}/addEducation/")
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