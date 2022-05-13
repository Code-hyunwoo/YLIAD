package com.yliad.diary.dto.response;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyPageResponseDto {

    @NotNull
    private int monthCount;
    @NotNull
    private int yearCount;
    @NotNull
    private int totalCount;

    @NotNull
    private int joy;
    @NotNull
    private int sad;
    @NotNull
    private int anger;
    @NotNull
    private int fear;
    @NotNull
    private int disgust;
    @NotNull
    private int love;

    @Builder
    public MyPageResponseDto(int monthCount, int yearCount, int totalCount, int joy, int sad, int anger, int fear, int disgust, int love) {
        this.monthCount = monthCount;
        this.yearCount = yearCount;
        this.totalCount = totalCount;
        this.joy = joy;
        this.sad = sad;
        this.anger = anger;
        this.fear = fear;
        this.disgust = disgust;
        this.love = love;
    }
}
