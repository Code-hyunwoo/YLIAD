package com.yliad.user.dto.request;

import com.sun.istack.NotNull;
import com.yliad.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SaveUserRequestDto {
    @NotNull
    private String loginId;
    @NotNull
    private String nickname;
    @NotNull
    private String password;

    @Builder
    public SaveUserRequestDto(String loginId, String nickname, String password) {
        this.loginId = loginId;
        this.nickname = nickname;
        this.password = password;
    }

    public User toEntity(){
        User user = User.builder()
                .loginId(loginId)
                .nickname(nickname)
                .password(password)
                .build();
        return user;
    }
}
