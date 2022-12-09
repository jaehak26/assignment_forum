package com.example.assignment_forum.repository;

import com.example.assignment_forum.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    //finding userId to DB data
    UserEntity findByUserId(String userId);
}
