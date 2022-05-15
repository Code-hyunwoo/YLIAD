package com.yliad.diary.repository;

import com.yliad.diary.dto.request.DiaryRequestDto;
import com.yliad.diary.dto.request.EmotionDto;
import com.yliad.diary.dto.response.CalendarResponseDto;
import com.yliad.diary.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Month;
import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

    @Query(nativeQuery = true, value = "SELECT count(diary_Date)\n" +
            "FROM DIARY\n" +
            "WHERE userid = :userid AND YEAR(diary_Date) = :year AND MONTH(diary_Date) = :month\n")
    Integer countDiaryMonth(@Param("userid") Long userid, @Param("year") int year, @Param("month") int month);

    @Query(nativeQuery = true, value = "SELECT count(diary_Date)\n" +
            "FROM DIARY\n" +
            "WHERE userid = :userid AND YEAR(diary_Date) = :year\n")
    Integer countDiaryYear(@Param("userid") Long userid, @Param("year") int year);

    @Query(nativeQuery = true, value = "SELECT count(diary_Date)\n" +
            "FROM DIARY\n" +
            "WHERE userid = :userid\n")
    Integer countDiaryTotal(@Param("userid") Long userid);

    @Query(nativeQuery = true, value ="SELECT emotion\n" +
            "FROM DIARY\n" +
            "WHERE userid = :userid AND YEAR(diary_Date) = :year AND MONTH(diary_Date) = :month\n" +
            "GROUP BY emotion\n" +
            "ORDER BY emotion")
    List<String> countMonthEmotion(@Param("userid") Long userid, @Param("year") int year, @Param("month") int month);

    @Query(nativeQuery = true, value = "SELECT count(emotion)\n" +
            "FROM DIARY\n" +
            "WHERE userid = :userid AND YEAR(diary_Date) = :year AND MONTH(diary_Date) = :month\n" +
            "GROUP BY emotion\n" +
            "ORDER BY emotion")
    List<Integer> countMonthEmotionCount(@Param("userid") Long userid, @Param("year") int year, @Param("month") int month);

    @Query(nativeQuery = true, value = "SELECT count(emotion)\n" +
            "FROM DIARY\n" +
            "WHERE userid = :userid AND YEAR(diary_Date) = :year AND MONTH(diary_Date) = :month\n" +
            "GROUP BY emotion\n" +
            "ORDER BY emotion")
    List<CalendarResponseDto> findDiaryByDiaryDateAndUserID(Long userid, int month);
}