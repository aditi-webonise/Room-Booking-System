package com.webonise.rbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("welcome");
    }

    @GetMapping(value = "/error")
    public ModelAndView error() {
        return new ModelAndView("error");
    }

    @GetMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping(value = "/admin")
    public ModelAndView admin() {
        return new ModelAndView("admindashboard");
    }
}
