package com.example.t2204msem4springshopping.controller_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("user", principal);
        return "index";
    }
}
