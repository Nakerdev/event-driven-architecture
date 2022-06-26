package com.webapplication.pages.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    public HomeController() {
    }

    @GetMapping(value = {"/", "home"})
    public ModelAndView home(final Model model) {
        return new ModelAndView("home/index");
    }

}
