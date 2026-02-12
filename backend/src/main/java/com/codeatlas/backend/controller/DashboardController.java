package com.codeatlas.backend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(Authentication authentication) {

        return "Welcome to Dashboard: " +
                authentication.getName();
    }
}
