package com.yliad.user_api.repository;

import com.yliad.user_api.entity.User_diary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User_diaryRepository extends JpaRepository<User_diary, Long> {
}