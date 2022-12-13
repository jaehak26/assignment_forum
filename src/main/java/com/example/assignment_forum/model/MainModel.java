package com.example.assignment_forum.model;

import lombok.*;
import org.springframework.web.bind.annotation.RequestParam;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MainModel {
    private String writeBeforeLogin = "true";
    private String afterLoginId = "";
    private int page = 0;
    private int size = 2;
    private String isUserExist = "";
}
