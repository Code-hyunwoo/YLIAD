package com.yliad.diary.repository;

import com.yliad.diary.dto.request.EmotionDto;

import java.util.List;

public interface DiaryQueryRepository {

    List<EmotionDto> findDiaryByDiaryDateAndUserIDOrderByDiaryDate(Long userid, int month);
}
