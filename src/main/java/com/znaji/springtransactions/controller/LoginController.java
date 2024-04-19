package com.znaji.springtransactions.controller;

import com.znaji.springtransactions.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes("username")
@RequiredArgsConstructor
public class LoginController {

    private final AuthService authService;

    @GetMapping("")
    public String loginPage() {
        return "login";
    }

    @PostMapping("")
    public String login(Model model, @RequestParam String username, @RequestParam String password) {
        if (authService.login(username, password)) {
            model.addAttribute("username", username);
            return "redirect:/course";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
