package com.yliad.user.dto.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UpdateFontSettingRequestDto {
    @NotNull
    private String fontName;
}
