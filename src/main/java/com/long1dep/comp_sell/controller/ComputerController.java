package com.long1dep.comp_sell.controller;

import com.long1dep.comp_sell.entity.Computer;
import com.long1dep.comp_sell.entity.User;
import com.long1dep.comp_sell.service.ComputerService;
import com.long1dep.comp_sell.service.ManufacturerService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/computers")
public class ComputerController {
//    @Autowired
    private final ComputerService compService;

    public ComputerController(ComputerService compService, ManufacturerService manuService) {
        this.compService = compService;
        this.manuService = manuService;
    }

    //    @Autowired
    private final ManufacturerService manuService;

    @GetMapping
    public String showAllComputers(Model model, HttpSession session) {
        if (session.getAttribute("loggedIn") == null) {
            return "redirect:/login";
        }

        model.addAttribute("comps", compService.showAllComputers());

        return "computers";
    }

    @GetMapping("/edit/{id}")
    public String editComputer(@PathVariable("id") long id, Model model, HttpSession session, RedirectAttributes invalidBox) {

        User u = (User) session.getAttribute("loggedIn");
        if (u == null) {
            return "redirect:/login";
        }
        if (!u.getRole().equals("Admin")) {
            invalidBox.addFlashAttribute("invalidRole", "You don't have permission to perform this operation");
            return "redirect:/computers";
        }

        model.addAttribute("ObjX", compService.getComputerById(id));
        model.addAttribute("manus", manuService.getAllManufacturer());
        return "computer-form";
    }
    @GetMapping("/create")
    public String createComputer(Model model,  HttpSession session, RedirectAttributes invalidBox) {
        User u = (User) session.getAttribute("loggedIn");
        if (u == null) {
            return "redirect:/login";
        }
        if (!u.getRole().equals("Admin")) {
            invalidBox.addFlashAttribute("invalidRole", "You dont have permission to perform this operation");
            return "redirect:/computers";
        }
        model.addAttribute("ObjX", new Computer());
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

        compService.saveComputer(x);
        return  "redirect:/computers";
    }

    @GetMapping("/delete/{id}")
    public String deleteComputer(@PathVariable("id") long id, Model model, HttpSession session,  RedirectAttributes invalidBox) {
        User u = (User) session.getAttribute("loggedIn");
        if (u == null) {
            return "redirect:/login";
        }
        if (!u.getRole().equals("Admin")) {
            invalidBox.addFlashAttribute("invalidRole", "You dont have permission to perform this operation");
            return "redirect:/computers";
        }
        compService.deleteComputerById(id);
        return "redirect:/computers";
    }
}
