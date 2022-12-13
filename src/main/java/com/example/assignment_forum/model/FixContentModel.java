package com.example.assignment_forum.model;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FixContentModel {
    private String afterLoginId = "";
    private long contentId;
    private String writingTitle;
    private String writingContent;

}
