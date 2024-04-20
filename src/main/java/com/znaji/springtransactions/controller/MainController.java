package com.znaji.springtransactions.controller;

import com.znaji.springtransactions.model.Address;
import com.znaji.springtransactions.model.Item;
import com.znaji.springtransactions.service.AddressService;
import com.znaji.springtransactions.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequiredArgsConstructor
@SessionAttributes("username")
public class MainController {

    private final ItemService itemService;
    private final AddressService addressService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("username", getNameFromSpringSecurityContext());
        return "home";
    }

    private String getNameFromSpringSecurityContext() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
