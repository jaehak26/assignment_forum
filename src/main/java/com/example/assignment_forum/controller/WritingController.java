package com.example.assignment_forum.controller;

import com.example.assignment_forum.entity.WritingEntity;
import com.example.assignment_forum.model.WriteOnBoardModel;
import com.example.assignment_forum.service.WriteOnBoardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class WritingController {
    WriteOnBoardService writeOnBoardService;

    @PostMapping("/writeOnBoard")
    public  String beforeWriting(@RequestParam(name="afterLoginId",required = false)String afterLoginId,
                                 Model model, RedirectAttributes re){
        if(afterLoginId.equals("")){
            re.addFlashAttribute("writeBeforeLogin", "false");
            return "redirect:/main";
        }

        model.addAttribute("afterLoginId",afterLoginId);

        return "writeOnBoard";
    }

    @PostMapping("/writeContent")
    public String writeContent(
                               @RequestParam String writingTitle,
                               @RequestParam String writingContent,
                               @RequestParam(defaultValue = "") String afterLoginId,
                               RedirectAttributes re){

        WriteOnBoardModel writeOnBoardModel =WriteOnBoardModel.builder()
                .writingContent(writingContent)
                .writingTitle(writingTitle)
                .afterLoginId(afterLoginId).build();

        writeOnBoardService.actionWriteContent(writeOnBoardModel);

        re.addAttribute("afterLoginId",writeOnBoardModel.getAfterLoginId());
        return "redirect:/main/afterLogin";
    }


}
