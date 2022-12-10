package com.example.assignment_forum.controller;

import com.example.assignment_forum.entity.UserEntity;
import com.example.assignment_forum.model.InputLoginModel;
import com.example.assignment_forum.model.InputUserRegisterModel;
import com.example.assignment_forum.repository.UserRepository;
import com.example.assignment_forum.service.UserLoginService;
import com.example.assignment_forum.service.UserRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private UserRegisterService userRegisterService;

    @PostMapping("/user/login")
    //InputLoginModel is form data
    public String userLogin(InputLoginModel loginModel, Model model){

        String afterLoginId = userLoginService.actionLogin(loginModel);

        String inexist = "false";
        //error
        if(afterLoginId ==null){
            inexist = "true";
            model.addAttribute("inexist", inexist);
            return "login";
        }

        model.addAttribute("inexist", inexist);
        model.addAttribute("afterLoginId", afterLoginId);

        return "main";
    }

    public ModelAndView userRegister(InputUserRegisterModel registerModel){

        String isUserExist = userRegisterService.isExistUser(registerModel);

        if(isUserExist=="true"){
            ModelAndView userRegisterView = new ModelAndView("userRegister");
            userRegisterView.addObject("isUserExist",isUserExist);
            return userRegisterView;
        }

        userRegisterService.actionUserRegister(registerModel);

        ModelAndView mainView = new ModelAndView("main");
        return mainView;
    }
}
