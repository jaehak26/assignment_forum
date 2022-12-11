package com.example.assignment_forum.service;

import com.example.assignment_forum.entity.WritingEntity;
import com.example.assignment_forum.model.WriteOnBoardModel;
import com.example.assignment_forum.repository.WritingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class WriteOnBoardService {

    @Autowired
    WritingRepository writingRepository;

    //내용
    public void actionWriteContent(WriteOnBoardModel boardModel){

        WritingEntity writingEntity = WritingEntity.builder()
                .userId(boardModel.getAfterLoginId())
                .title(boardModel.getWritingTitle())
                .contentText(boardModel.getWritingContent())
                .regTime(LocalDateTime.now())
                .build();

        writingRepository.save(writingEntity);
    }
}
