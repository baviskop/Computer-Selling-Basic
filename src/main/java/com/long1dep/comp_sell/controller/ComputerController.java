package com.long1dep.comp_sell.controller;

import com.long1dep.comp_sell.entity.Computer;
import com.long1dep.comp_sell.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/computers")
public class ComputerController {
    @Autowired
    private ComputerService compService;

    @GetMapping
    public String showAllComputers(Model model) {
        model.addAttribute("comps", compService.showAllComputers());

        return "computers";
    }

    @GetMapping("/edit/{id}")
    public String editComputer(@PathVariable("id") long id, Model model) {
        model.addAttribute("ObjX", compService.getComputerById(id));
        return "computer-form";
    }
}
