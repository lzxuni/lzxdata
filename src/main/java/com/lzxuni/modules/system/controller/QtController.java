package com.lzxuni.modules.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class QtController {

    @RequestMapping("/qt/login.html")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView("/qt/login");
        return mv;
    }
}
