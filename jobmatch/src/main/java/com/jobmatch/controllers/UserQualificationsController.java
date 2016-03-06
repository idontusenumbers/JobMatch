package com.jobmatch.controllers;

import com.jobmatch.models.Education;
import com.jobmatch.models.RankedCulture;
import com.jobmatch.models.RankedSkill;
import com.jobmatch.models.User;
import com.jobmatch.viewmodels.RankMap;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/users/{userId}/qualifications")
public class UserQualificationsController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public View updateQualifications(@PathVariable int userId, @ModelAttribute User user,
                                     String[] skills, String[] skillsRanks,
                                     String[] cultures, String[] culturesRanks, Model model) {
        User existingUser = userRepository.findOne(userId);
        enforceSameUserUnlessAdmin(existingUser);

        BeanUtils.copyProperties(user, existingUser, "id", "username", "password", "role", "optIn", "contact");

        RankedSkill.updateSkillSet(skills, skillsRanks, existingUser.getSkills(), skillRepository);
        RankedCulture.updateCultureSet(cultures, culturesRanks, existingUser.getCultures(), cultureRepository);

        userRepository.save(existingUser);
        return getRedirectView("/");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getQualifications(@PathVariable int userId, Model model) {
        User user = userRepository.findOne(userId);
        enforceSameUserUnlessAdmin(user);
        model.addAttribute("user", user);
        model.addAttribute("skills", new RankMap<>(user.getSkills()));
        model.addAttribute("cultures", new RankMap<>(user.getCultures()));
        model.addAttribute("resume", user.getResume());
        model.addAttribute("references", user.getReferences());
        model.addAttribute("education", new Education());
        model.addAttribute("educationList", user.getEducationList());

        model.addAttribute("cultureOptions", cultureRepository.getMap());
        model.addAttribute("skillOptions", skillRepository.getMap());

        return "qualifications/edit";
    }

    @RequestMapping(value = "/addEducation", method = RequestMethod.POST)
    public View addEducation(@PathVariable int userId, @ModelAttribute Education education) {
        User user = userRepository.findOne(userId);
        user.getEducation().add(education);
        userRepository.save(user);

        return getRedirectView("/");
    }
}
