package com.example.assignment_forum.model;

import lombok.*;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ViewContentModel {
    private String afterLoginId = "";
    private long contentId;
    private String validFix="true";
}
