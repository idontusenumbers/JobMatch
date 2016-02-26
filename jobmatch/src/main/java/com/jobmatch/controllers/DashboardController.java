package com.jobmatch.controllers;

import com.jobmatch.models.Role;
import com.jobmatch.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController extends BaseController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Dashboard");
        User user = getCurrentUser();
        if (user.getRole().getId() == Role.EMPLOYER) {
            return "dashboard/employer";
        } else if (user.getRole().getId() == Role.SEEKER) {
            return "dashboard/seeker";
        }

        return "dashboard/home";
    }
}
