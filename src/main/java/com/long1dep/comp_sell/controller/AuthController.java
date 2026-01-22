package com.long1dep.comp_sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping({"/", "/login", "/baviskop"})
    public String login() {
        return "login.html";
    }
}
