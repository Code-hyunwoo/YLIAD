package com.yliad.diary.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "diaryId")
    private Long id;

    @CreatedDate
    private LocalDateTime diaryDate;

    private String content;

    private String emotion;

    private String voiceFilePath;

    private Long userID;

    @Builder
    public Diary(Long id, LocalDateTime diaryDate, String content, String emotion, String voiceFilePath, Long userID) {
        this.id = id;
        this.diaryDate = diaryDate;
        this.content = content;
        this.emotion = emotion;
        this.voiceFilePath = voiceFilePath;
        this.userID = userID;
    }
}
