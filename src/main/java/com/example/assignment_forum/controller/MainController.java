package com.example.assignment_forum.controller;


import com.example.assignment_forum.entity.WritingEntity;
import com.example.assignment_forum.service.MainBoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;

@Controller
@RequestMapping
@AllArgsConstructor
public class MainController {

    @Autowired
    private MainBoardService mainBoardService;

    @RequestMapping("/main")
    public String main1(@RequestParam(name="writeBeforeLogin",required = false)String writeBeforeLogin,
                        @RequestParam(name="afterLoginId",required = false)String afterLoginId,
                        Model model){
        if(writeBeforeLogin!=null)
            model.addAttribute("writeBeforeLogin",writeBeforeLogin);

        if(afterLoginId!=null)
            model.addAttribute("afterLoginId",afterLoginId);


        List<WritingEntity> writingEntityList = mainBoardService.mainBoard();
        System.out.println(writingEntityList);
        model.addAttribute("writingEntityList",writingEntityList);

        System.out.println(afterLoginId);
        return "main";
    }

    @GetMapping("/main/afterLogin")
    public String main2(@RequestParam(name="afterLoginId",required = false)String afterLoginId,
                        RedirectAttributes model){
        if(afterLoginId!=null)
            model.addFlashAttribute("afterLoginId",afterLoginId);

        List<WritingEntity> writingEntityList = mainBoardService.mainBoard();
        System.out.println(writingEntityList);

        model.addAttribute("writingEntityList",writingEntityList);
        return "redirect:/main";
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
