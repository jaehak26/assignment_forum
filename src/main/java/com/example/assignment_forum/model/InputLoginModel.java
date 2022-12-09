package com.example.assignment_forum.model;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InputLoginModel {
    private String loginId="";
    private String loginPwd="";
}
