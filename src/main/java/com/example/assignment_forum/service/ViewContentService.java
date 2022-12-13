package com.example.assignment_forum.service;

import com.example.assignment_forum.entity.WritingEntity;
import com.example.assignment_forum.repository.WritingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ViewContentService {
    @Autowired
    WritingRepository writingRepository;

    public WritingEntity viewContent(long contentId){
        Optional<WritingEntity> result = writingRepository.findById(contentId);
        WritingEntity writingEntity = result.get();
        return writingEntity;
    }
}
