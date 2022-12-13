package com.example.assignment_forum.repository;

import com.example.assignment_forum.entity.WritingEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WritingRepository extends JpaRepository<WritingEntity,Long> {

    WritingEntity findByUserId(String userId);

    List<WritingEntity> findAllByOrderByContentIdDesc();

    List<WritingEntity> findAllByOrderByContentIdAsc();

    Page<WritingEntity> findAll(Pageable pageable);
}
