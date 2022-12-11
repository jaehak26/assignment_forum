package com.example.assignment_forum.model;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewOnBoardModel {
    private String readingTitle;
    private String readingContent;
    private String afterLoginId;
    private String contentId;
}
