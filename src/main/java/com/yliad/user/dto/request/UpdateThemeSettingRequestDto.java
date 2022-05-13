package com.yliad.user.dto.request;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UpdateThemeSettingRequestDto {
    @NotNull
    private String themeName;
}
