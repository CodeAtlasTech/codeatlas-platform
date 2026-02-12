package com.codeatlas.backend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/success")
    public String success(Authentication authentication) {
        return "Login Successful! Your email is: " + authentication.getName();
    }
}
