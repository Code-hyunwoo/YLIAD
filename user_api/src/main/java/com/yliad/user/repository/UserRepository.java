package com.yliad.user.repository;

import com.yliad.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByNickname(String nickname);
    Boolean existsByLoginid(String loginid);
}