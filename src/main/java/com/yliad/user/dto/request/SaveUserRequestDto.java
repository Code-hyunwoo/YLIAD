package com.yliad.user.dto.request;

import com.sun.istack.NotNull;
import com.yliad.user.entity.User;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
public class SaveUserRequestDto {
    @NotNull
    private String loginId;
    @NotNull
    private String nickname;
    @NotNull
    private String password;

    public User toEntity(){
        return User.builder()
                .loginId(loginId)
                .nickname(nickname)
                .password(password)
                .build();
    }
}
