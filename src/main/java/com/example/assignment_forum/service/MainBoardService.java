package com.example.assignment_forum.service;

import com.example.assignment_forum.entity.WritingEntity;
import com.example.assignment_forum.repository.WritingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MainBoardService {
    @Autowired
    private WritingRepository writingRepository;

    public List<WritingEntity> mainBoard(){
        List<WritingEntity> writingEntityList = writingRepository.findAllByOrderByContentIdDesc();

        return writingEntityList;
    }

    public List<WritingEntity> mainContentList(Integer page, Integer size){
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("contentId").descending());
        List<WritingEntity> writingEntityList = writingRepository.findAll(pageRequest).getContent();

        return  writingEntityList;
    }

    public Page<WritingEntity> mainContentPage(Integer page, Integer size){
        Page<WritingEntity> writingEntityPage = writingRepository.findAll(PageRequest.of(page,size));

        return writingEntityPage;
    }
}
