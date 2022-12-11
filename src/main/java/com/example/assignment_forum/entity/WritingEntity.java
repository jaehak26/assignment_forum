package com.example.assignment_forum.entity;

import javax.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_writing")
public class WritingEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long contentId;

    @Column(nullable = false, length = 30)
    private String userId;

    @Column(nullable = false, length = 50)
    private String title;

    @Lob
    @Column(nullable = true)
    private String contentText;

    @Column
    private LocalDateTime regTime;

    @Column
    private  LocalDateTime updateTime;
}
