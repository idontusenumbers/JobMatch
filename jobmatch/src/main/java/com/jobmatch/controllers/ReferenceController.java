package com.jobmatch.controllers;

import com.jobmatch.models.Reference;
import com.jobmatch.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

@Controller
@RequestMapping("/users/{userId}/reference")
public class ReferenceController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String viewReference(@PathVariable int userId, Model model) {
        enforceSameUserUnlessAdmin(userId);

        User user = userRepository.findOne(userId);
        model.addAttribute("referenceList", user.getReferences());
        model.addAttribute("currentUser", user);

        return "references/view";
    }

    @RequestMapping(value = "/{referenceId}/edit", method = RequestMethod.GET)
    public String editReference(@PathVariable int userId, @PathVariable int referenceId, Model model) {
        enforceSameUserUnlessAdmin(userId);
        model.addAttribute("reference", referenceRepository.findOne(referenceId));
        model.addAttribute("user", getCurrentUser());

        return "references/edit";
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public View addReference(@PathVariable int userId, @ModelAttribute Reference reference) {
        enforceSameUserUnlessAdmin(userId);
        User user = getCurrentUser();
        user.getReferences().add(reference);
        userRepository.save(user);

        return getRedirectView("/users/{userId}/reference/".replace("{userId}", String.valueOf(userId)));
    }

    @RequestMapping(value = "/{referenceId}", method = RequestMethod.POST)
    public View updateReference(@PathVariable int userId, @PathVariable int referenceId, @ModelAttribute Reference reference) {
        enforceSameUserUnlessAdmin(userId);
        reference.setId(referenceId);
        referenceRepository.save(reference);

        return getRedirectView("/users/{userId}/reference/".replace("{userId}", String.valueOf(userId)));
    }

    @RequestMapping(value = "/{referenceId}/delete", method = RequestMethod.GET)
    public View deleteReference(@PathVariable int userId, @PathVariable int referenceId) {
        enforceSameUserUnlessAdmin(userId);
        User user = getCurrentUser();
        user.getReferences().remove(referenceRepository.findOne(referenceId));
        userRepository.save(user);

        return getRedirectView("/users/{userId}/reference/".replace("{userId}", String.valueOf(userId)));
    }
}
