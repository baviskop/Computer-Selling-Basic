package com.long1dep.comp_sell.controller;

import com.long1dep.comp_sell.entity.User;
import com.long1dep.comp_sell.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    //    @Autowired
    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/login", "/baviskop"})
    public String login() {
        return "login";
    }

    @PostMapping("/auth")
    public String authenticate(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes box, HttpSession session) {

        User u = userService.authenticate(email, password);
        if (u == null) {
            box.addFlashAttribute("error", "Invalid email or password");
            return "redirect:/login";
        }
        if(u.getRole().equalsIgnoreCase("member")) {
            box.addFlashAttribute("error", "You dont have permission to access this resource");
            return "redirect:/login";
        }

        session.setAttribute("loggedIn", u);
        return "redirect:/computers";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
