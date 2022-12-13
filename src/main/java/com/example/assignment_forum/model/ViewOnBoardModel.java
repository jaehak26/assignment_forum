package com.example.assignment_forum.model;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewOnBoardModel {
    private String afterLoginId="";
    private long contentId;
}
