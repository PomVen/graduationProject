package com.hallth.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/theme")
public class ThemeController {
    private static Logger logger = Logger.getLogger(LoginController.class.getName());

    public String addTheme(){
        return "";
    }
}
