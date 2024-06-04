package com.example.practice15.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.practice15.models.User;
import com.example.practice15.services.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/login")
public class AuthController {
    private final UserService userService;

    @GetMapping
    @ResponseBody
    public boolean login(@RequestBody User user) {
        return userService.login(user);
    }

    @PostMapping("/registration")
    @ResponseBody
    public void registration(@RequestBody User user) {
        userService.saveUser(user);
    }
}