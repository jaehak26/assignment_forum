package com.example.assignment_forum.controller;

import com.example.assignment_forum.entity.UserEntity;
import com.example.assignment_forum.model.InputLoginModel;
import com.example.assignment_forum.repository.UserRepository;
import com.example.assignment_forum.service.UserLoginService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
public class UserController {

    private UserLoginService userLoginService;

    public UserController(UserLoginService userLoginService){
        this.userLoginService = userLoginService;
    }

    @PostMapping("/user/login")
    //InputLoginModel is form data
    public String userLogin(InputLoginModel loginModel, Model model){

        String afterLoginId = userLoginService.actionLogin(loginModel);

        boolean inexist = false;
        //error
        if(afterLoginId ==null){
            inexist = true;
            model.addAttribute("inexist", inexist);
            return "login";
        }

        model.addAttribute("inexist", inexist);
        model.addAttribute("afterLoginId", afterLoginId);

        return "main";
    }
}
