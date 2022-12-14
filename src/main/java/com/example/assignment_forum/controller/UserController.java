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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String userLogin(InputLoginModel loginModel, RedirectAttributes model){


        String afterLoginId = userLoginService.actionLogin(loginModel);

        String inexist = "false";
        //error
        if(afterLoginId.equals("")){
            inexist = "true";
            model.addAttribute("inexist", inexist);
            return "login";
        }

        model.addAttribute("afterLoginId", afterLoginId);


        return "redirect:/main/afterLogin";
    }

    @PostMapping("/user/register")
    public String userRegister(InputUserRegisterModel registerModel, RedirectAttributes model){

        if(registerModel.getUserId().equals("")){
            String invalidId = "true";
            model.addAttribute("invalidId", invalidId);
            return "userRegiser";
        }

        String isUserExist = userRegisterService.isExistUser(registerModel);

        if(isUserExist.equals("true")){
            model.addAttribute("isUserExist",isUserExist);
            return "userRegister";
        }

        userRegisterService.actionUserRegister(registerModel);
        model.addAttribute("isUserExist", isUserExist);
        return "redirect:/main";
    }
}
