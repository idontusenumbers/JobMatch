package com.jobmatch.controllers;

import com.github.javafaker.Faker;
import com.jobmatch.models.Education;
import com.jobmatch.models.Role;
import com.jobmatch.models.User;
import com.jobmatch.viewmodels.RankMap;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.View;

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

    @RequestMapping(value = "{userId}", method = RequestMethod.GET)
    public String viewUser(@PathVariable int userId, Model model) {
        User user = userRepository.findOne(userId);
        enforceSameUserOrEmployer(user);
        model.addAttribute("user", user);
        model.addAttribute("skills", new RankMap<>(user.getSkills()));
        model.addAttribute("cultures", new RankMap<>(user.getCultures()));
        return "users/view-candidate";
    }


    @RequestMapping(value = "{userId}/profile", method = RequestMethod.GET)
    public String getProfile(@PathVariable int userId, Model model) {
        User user = userRepository.findOne(userId);
        enforceSameUserUnlessAdmin(user);
        model.addAttribute("user", user);
        switch (user.getRole().getId()) {
            case Role.ADMIN:
            case Role.SEEKER:
                return "users/profile-seeker";
            case Role.EMPLOYER:
                return "users/profile-employer";
            default:
                throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @RequestMapping(value = "{userId}/profile", method = RequestMethod.POST)
    public View putProfile(@PathVariable int userId, @ModelAttribute User updatedUser, Model model) {
        enforceSameUserUnlessAdmin(userId);

        User user = userRepository.findOne(userId);
        BeanUtils.copyProperties(updatedUser, user, "id", "username", "password", "role", "optIn", "contact.email", "resume", "references", "company");
        userRepository.save(user);

        return getRedirectView("/");
    }

    @RequestMapping(value = "{userId}/delete")
    public View delete(@PathVariable int userId, Model model) {
        User user = userRepository.findOne(userId);
        enforceSameUserUnlessAdmin(user);

        userRepository.delete(user.getId());

        if (getCurrentUser().getRole().getId() == Role.ADMIN) {
            return getRedirectView("../");
        } else {
            return getRedirectView("/logout");
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
                    String.valueOf(faker.date().past(365, TimeUnit.DAYS).getYear())
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