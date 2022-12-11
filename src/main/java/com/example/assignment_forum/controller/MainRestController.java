package com.example.assignment_forum.controller;

import com.example.assignment_forum.entity.WritingEntity;
import com.example.assignment_forum.service.MainBoardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class MainRestController {
    @Autowired
    private MainBoardService mainBoardService;

    @GetMapping("/mainContent/list")
    public List<WritingEntity> mainContentListJson(@RequestParam(name="page",defaultValue = "0")Integer page,
                                               @RequestParam(name="size",defaultValue = "2")Integer size){

        List<WritingEntity> writingEntityList = mainBoardService.mainContentList(page, size);

        return writingEntityList;
    }

    @GetMapping("/mainContent/page")
    public Page<WritingEntity> mainContentPageJson(@RequestParam(name="page",defaultValue = "0")Integer page,
                                                   @RequestParam(name="size",defaultValue = "2")Integer size){

        Page<WritingEntity> writingEntityPage = mainBoardService.mainContentPage(page, size);

        return writingEntityPage;
    }
}
