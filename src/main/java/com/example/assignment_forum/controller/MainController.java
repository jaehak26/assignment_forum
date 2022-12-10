package com.example.assignment_forum.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class MainController {

    @GetMapping("/main")
    public String main1(){
        System.out.println("main");
        return "main";
    }

    @GetMapping("/main/afterLogin")
    public String main2(@RequestParam("afterLoginId")String afterLoginId, Model model){
            model.addAttribute("afterLoginId",afterLoginId);
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
