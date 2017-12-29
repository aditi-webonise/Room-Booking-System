package com.webonise.rbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    public ModelAndView index() {
        return new ModelAndView("admindashboard");
    }
}
