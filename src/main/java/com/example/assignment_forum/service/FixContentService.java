package com.example.assignment_forum.service;

import com.example.assignment_forum.entity.WritingEntity;
import com.example.assignment_forum.model.FixContentModel;
import com.example.assignment_forum.repository.WritingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FixContentService {
    @Autowired
    WritingRepository writingRepository;

    public void actionFixContent(FixContentModel fixContentModel){

        WritingEntity writingEntity = WritingEntity.builder()
                .contentId(fixContentModel.getContentId())
                .userId(fixContentModel.getAfterLoginId())
                .title(fixContentModel.getWritingTitle())
                .contentText(fixContentModel.getWritingContent())
                .updateTime(LocalDateTime.now())
                .build();

        writingRepository.save(writingEntity);
    }
}
