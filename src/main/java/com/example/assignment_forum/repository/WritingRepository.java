package com.example.assignment_forum.repository;

import com.example.assignment_forum.entity.WritingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WritingRepository extends JpaRepository<WritingEntity,Long> {

    WritingEntity findByUserId(String userId);

    @Override
    Page<WritingEntity> findAll(Pageable pageable);
}
