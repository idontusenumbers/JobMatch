package com.jobmatch.controllers;

import com.jobmatch.models.Education;
import com.jobmatch.models.JobPost;
import com.jobmatch.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/users/{userId}/education")
public class EducationController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewEducation(@PathVariable int userId, Model model) {
        enforceSameUserUnlessAdmin(userId);

        User user = userRepository.findOne(userId);
        model.addAttribute("educationList", user.getEducationList());
        model.addAttribute("currentUser", user);
        model.addAttribute("countries", JobPost.getCountryList());

        return "education/view";
    }

    @RequestMapping(value = "/{educationId}/edit", method = RequestMethod.GET)
    public String editEducation(@PathVariable int userId, @PathVariable int educationId, Model model) {
        enforceSameUserUnlessAdmin(userId);
        model.addAttribute("education", educationRepository.findOne(educationId));
        model.addAttribute("user", getCurrentUser());
        model.addAttribute("countries", JobPost.getCountryList());

        return "education/edit";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public View addEducation(@PathVariable int userId, @ModelAttribute Education education) {
        enforceSameUserUnlessAdmin(userId);
        User user = getCurrentUser();
        user.getEducation().add(education);
        userRepository.save(user);

        return getRedirectView("/users/{userId}/education/".replace("{userId}", String.valueOf(userId)));
    }

    @RequestMapping(value = "/{educationId}", method = RequestMethod.POST)
    public View updateEducation(@PathVariable int userId, @PathVariable int educationId, @ModelAttribute Education education) {
        enforceSameUserUnlessAdmin(userId);
        education.setId(educationId);
        educationRepository.save(education);

        return getRedirectView("/users/{userId}/education/".replace("{userId}", String.valueOf(userId)));
    }

    @RequestMapping(value = "/{educationId}/delete", method = RequestMethod.GET)
    public View deleteEducation(@PathVariable int userId, @PathVariable int educationId) {
        enforceSameUserUnlessAdmin(userId);
        User user = getCurrentUser();
        user.getEducation().remove(educationRepository.findOne(educationId));
        userRepository.save(user);

        return getRedirectView("/users/{userId}/education/".replace("{userId}", String.valueOf(userId)));
    }
}
