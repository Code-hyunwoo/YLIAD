package com.yliad.diary.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class DiaryRequestDto {
    @NotNull
    private Long userID;
    @NotNull
    private LocalDateTime currentTime;


}
