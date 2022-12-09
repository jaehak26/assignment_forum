package com.example.assignment_forum.model;

import com.example.assignment_forum.entity.UserEntity;
import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OutputUserRepositoryModel {

    private UserEntity userEntity = null;
    private boolean error = false;
}
