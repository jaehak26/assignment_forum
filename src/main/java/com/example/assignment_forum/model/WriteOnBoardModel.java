package com.example.assignment_forum.model;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WriteOnBoardModel {
    private String writingTitle;
    private String writingContent;
    private String afterLoginId;
}
