package com.example.assignment_forum.controller;

import com.example.assignment_forum.entity.WritingEntity;
import com.example.assignment_forum.model.FixContentModel;
import com.example.assignment_forum.model.ViewContentModel;
import com.example.assignment_forum.model.ViewOnBoardModel;
import com.example.assignment_forum.repository.WritingRepository;
import com.example.assignment_forum.service.DeleteContentService;
import com.example.assignment_forum.service.FixContentService;
import com.example.assignment_forum.service.ViewContentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class ContentViewController {

    @Autowired
    ViewContentService viewContentService;
    @Autowired
    FixContentService fixContentService;

    @Autowired
    DeleteContentService deleteContentService;
    @GetMapping("/viewContent")
    public String viewContent(ViewContentModel viewContentModel,
                              Model model){
        System.out.println(viewContentModel);

        WritingEntity viewContent = viewContentService.viewContent(viewContentModel.getContentId());
        model.addAttribute("readingTitle",viewContent.getTitle());
        model.addAttribute("readingContent",viewContent.getContentText());


        model.addAttribute("afterLoginId",viewContentModel.getAfterLoginId());

        model.addAttribute("contentId",viewContent.getContentId());
        model.addAttribute("writer", viewContent.getUserId());
        model.addAttribute("validFix", viewContentModel.getValidFix());


        return "viewOnBoard";
    }

    @PostMapping("/fixContent")
    public String beforeFixContent(@RequestParam String afterLoginId,
                                   @RequestParam int contentId,
                                   Model model,
                                   RedirectAttributes re){

        WritingEntity fixContent = viewContentService.viewContent(contentId);

        System.out.println(fixContent);
        System.out.println(afterLoginId);
        System.out.println(fixContent.getUserId());
        System.out.println(fixContent.getUserId().equals(afterLoginId));
        if(!fixContent.getUserId().equals(afterLoginId)){

            ViewContentModel viewContentModel = ViewContentModel.builder()
                    .contentId(contentId)
                    .afterLoginId(afterLoginId)
                    .validFix("false")
                    .build();

            re.addAttribute("afterLoginId",viewContentModel.getAfterLoginId());
            re.addAttribute("contentId",viewContentModel.getContentId());
            re.addAttribute("validFix", viewContentModel.getValidFix());

            return "redirect:/viewContent";
        }

        model.addAttribute("fixTitle",fixContent.getTitle());
        model.addAttribute("fixContent",fixContent.getContentText());
        model.addAttribute("afterLoginId",afterLoginId);
        model.addAttribute("contentId",fixContent.getContentId());

        return "fixContent";
    }

    @PostMapping("/fixContent/afterFix")
    public String afterFix(FixContentModel fixContentModel, RedirectAttributes re){
        fixContentService.actionFixContent(fixContentModel);
        re.addAttribute("afterLoginId",fixContentModel.getAfterLoginId());
        return "redirect:/main/afterLogin";
    }

    @PostMapping("/deleteContent")
    public String deleteContent(FixContentModel deleteContentModel, RedirectAttributes re){
        deleteContentService.actionDeleteContent(deleteContentModel.getContentId());
        re.addAttribute("afterLoginId",deleteContentModel.getAfterLoginId());
        return "redirect:/main/afterLogin";
    }
}
