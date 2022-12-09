package com.example.assignment_forum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {

    @GetMapping("/main")
    public String main1(){
        System.out.println("main");
        return "main";
    }

    @GetMapping("/login")
    public String userLogin1(){
        System.out.println("login");
        return "login";
    }

    @GetMapping("/userRegister")
    public String userRegister1(){
        return "userRegister";
    }
}
