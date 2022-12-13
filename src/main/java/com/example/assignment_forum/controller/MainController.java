package com.example.assignment_forum.controller;


import com.example.assignment_forum.entity.WritingEntity;
import com.example.assignment_forum.model.MainModel;
import com.example.assignment_forum.service.MainBoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public String main1(MainModel mainModel,
                        Model model){

        model.addAttribute("writeBeforeLogin",mainModel.getWriteBeforeLogin());
        model.addAttribute("afterLoginId",mainModel.getAfterLoginId());
        model.addAttribute("isUserExist",mainModel.getIsUserExist());


        List<WritingEntity> writingEntityList = mainBoardService.mainBoard();
        //System.out.println(writingEntityList);
        model.addAttribute("writingEntityList",writingEntityList);

        Page<WritingEntity> writingEntityPage = mainBoardService.mainContentPage(mainModel.getPage(), mainModel.getSize());
        model.addAttribute("totalPages",writingEntityPage.getTotalPages());
        model.addAttribute("thisPage",mainModel.getPage());
        System.out.println("afterLoginId: "+ mainModel.getAfterLoginId());
        System.out.println("page: "+mainModel.getPage());
        return "main";
    }

    @GetMapping("/main/afterLogin")
    public String main2(MainModel mainModel,
                        RedirectAttributes model){

        model.addFlashAttribute("mainModel",mainModel);

        System.out.println("model: "+ model);
        return "redirect:/main";
    }

    @GetMapping("/login")
    public String userLogin1(Model model){
        System.out.println("login");
        model.addAttribute("inexist","");
        return "login";
    }

    @GetMapping("/userRegister")
    public String userRegister1(Model model){
        model.addAttribute("isUserExist","");
        return "userRegister";
    }


}
