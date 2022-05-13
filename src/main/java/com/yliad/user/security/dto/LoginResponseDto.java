package com.yliad.user.security.dto;

import com.yliad.user.entity.User;
import com.yliad.user.entity.status.UserRole;
import java.util.Set;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 로그인 후 클라이언트에게 전달되는 반환 DTO
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class LoginResponseDto {

  private Long id;
  private UserRole role;
  private String nickname;

  public static LoginResponseDto of(User user) {
    return new LoginResponseDto(user.getId(),
        findHighestRole(user.getMemberRole()),
        user.getNickname());
  }

  /**
   * 멤버의 최상위 권한을 찾는 로직 ADMIN > COMPNAY > USER
   */
  private static UserRole findHighestRole(Set<UserRole> roles) {
    if (roles.contains(UserRole.ROLE_ADMIN)) {
      return UserRole.ROLE_ADMIN;
    }
    else {
      return UserRole.ROLE_USER;
    }
  }
}
