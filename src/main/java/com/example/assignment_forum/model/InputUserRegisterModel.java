package com.example.assignment_forum.model;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InputUserRegisterModel {
    private String userId="";
    private String userPwd="";
    private String userEmail;
    private String userPhone;
}
