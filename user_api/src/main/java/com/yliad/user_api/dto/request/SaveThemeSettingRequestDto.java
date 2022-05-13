package com.yliad.user_api.dto.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveThemeSettingRequestDto {
    @NotNull
    private Long userId;
    @NotNull
    private String themeName;

    @Builder
    public SaveThemeSettingRequestDto(Long userId, String themeName) {
        this.userId = userId;
        this.themeName = themeName;
    }


}
