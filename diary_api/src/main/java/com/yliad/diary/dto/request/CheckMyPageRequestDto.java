package com.yliad.diary.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CheckMyPageRequestDto {
    @NotNull
    private Long userID;
    @NotNull
    private LocalDateTime currentTime;


}
