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
public class DeleteContentService {
    @Autowired
    WritingRepository writingRepository;

    public void actionDeleteContent(long contentId){

        writingRepository.deleteById(contentId);
    }
}
