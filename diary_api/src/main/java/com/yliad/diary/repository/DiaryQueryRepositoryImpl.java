package com.yliad.diary.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.DateTemplate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yliad.diary.dto.request.EmotionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.yliad.diary.entity.QDiary.diary;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Repository
public class DiaryQueryRepositoryImpl implements DiaryQueryRepository {

    private final JPAQueryFactory query;

    @Override
    public List<EmotionDto> findDiaryByDiaryDateAndUserIDOrderByDiaryDate(Long userid, int month) {

        DateTemplate<LocalDateTime> formatDate =
                Expressions.dateTemplate(LocalDateTime.class,
                        "to_char({0}, {1})", diary.diaryDate, "YYYY-MM-DD");
        int currentYear = LocalDateTime.now().getYear();
        return query.select(
                        Projections.constructor(EmotionDto.class,
                                diary.diaryDate,
                                diary.emotion
                        ))
                .from(diary)
                .where(diary.userID.eq(userid)
                        .and(diary.diaryDate.year().eq(currentYear))
                        .and(diary.diaryDate.month().eq(month)))
                .groupBy(diary.id, formatDate)
                .having(diary.id.max().eq(userid))
                .orderBy(diary.id.asc())
//                .limit(1)
                .fetch();
    }
}
