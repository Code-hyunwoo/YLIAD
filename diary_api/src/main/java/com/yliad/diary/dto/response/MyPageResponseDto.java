package com.yliad.diary.dto.response;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
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
}
