package com.long1dep.comp_sell.controller;

import com.long1dep.comp_sell.entity.Computer;
import com.long1dep.comp_sell.service.ComputerService;
import com.long1dep.comp_sell.service.ManufacturerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/computers")
public class ComputerController {
    @Autowired
    private ComputerService compService;

    @Autowired
    private ManufacturerService manuService;

    @GetMapping
    public String showAllComputers(Model model) {
        model.addAttribute("comps", compService.showAllComputers());

        return "computers";
    }

    @GetMapping("/edit/{id}")
    public String editComputer(@PathVariable("id") long id, Model model) {
        model.addAttribute("ObjX", compService.getComputerById(id));
        model.addAttribute("manus", manuService.getAllManufacturer());
        return "computer-form";
    }

    @PostMapping("/save")
    public String saveComputer(@Valid @ModelAttribute("ObjX") Computer x, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("ObjX", x);
            model.addAttribute("manus", manuService.getAllManufacturer());
            return "computer-form";
        }

        compService.createComputer(x);
        return  "redirect:/computers";
    }
}
