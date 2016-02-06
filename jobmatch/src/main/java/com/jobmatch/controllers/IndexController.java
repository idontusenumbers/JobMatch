package com.jobmatch.controllers;

import com.jobmatch.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

@Controller
public class IndexController extends BaseController{


    @RequestMapping("/")
    public String index(Map<String, Object> model) {

		return "index";

    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Map<String, Object> model, String error) {
        if (error != null)
            model.put("errors", Arrays.asList("Unknown user or password"));

        return "index";

    }

    @RequestMapping("/register")
    public String getRegister() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String postRegister() {
        return "register";
    }

}