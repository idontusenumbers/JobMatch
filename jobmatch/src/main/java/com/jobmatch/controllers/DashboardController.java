package com.jobmatch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController extends BaseController {

    @RequestMapping("/home")
    public String home(Model model) {
        model.addAttribute("title", "Dashboard");

        return "dashboard/home";
    }
}
