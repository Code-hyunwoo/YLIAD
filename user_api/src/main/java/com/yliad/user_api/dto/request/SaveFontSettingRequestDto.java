package com.yliad.user_api.dto.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveFontSettingRequestDto {
    @NotNull
    private Long userId;
    @NotNull
    private String fontName;

    @Builder
    public SaveFontSettingRequestDto(Long userId, String fontName) {
        this.userId = userId;
        this.fontName = fontName;
    }


}
