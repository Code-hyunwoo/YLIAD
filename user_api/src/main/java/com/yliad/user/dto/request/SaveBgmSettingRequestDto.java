package com.yliad.user.dto.request;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveBgmSettingRequestDto {
    @NotNull
    private Long userId;
    @NotNull
    private String bgmName;

    @Builder
    public SaveBgmSettingRequestDto(Long userId, String bgmName) {
        this.userId = userId;
        this.bgmName = bgmName;
    }


}
