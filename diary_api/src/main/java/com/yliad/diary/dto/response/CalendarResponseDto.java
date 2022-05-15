package com.yliad.diary.dto.response;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalendarResponseDto {
    @NotNull
    private int date;
    @NotNull
    private String emotion;
}
