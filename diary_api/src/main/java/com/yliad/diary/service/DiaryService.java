package com.yliad.diary.service;

import com.yliad.diary.dto.request.SaveDiaryRequestDto;
import com.yliad.diary.dto.response.MyPageResponseDto;
import com.yliad.diary.entity.Diary;
import com.yliad.diary.repository.DiaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Month;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiaryService {

    private final DiaryRepository diaryRepository;

    //일기작성
    @Transactional
    public void saveDiary(SaveDiaryRequestDto requestDto) {
        Diary diary = requestDto.toEntity();
        diaryRepository.save(requestDto.toEntity());
    }

    public MyPageResponseDto getMyPage(Long userId, LocalDateTime currentTime){
        int year = currentTime.getYear();
        Month month = currentTime.getMonth();
        MyPageResponseDto responseDto = diaryRepository
                .


        return MyPageResponseDto.builder()
                .monthCount(responseDto.getMonthCount())
                .yearCount(responseDto.getYearCount())
                .totalCount(responseDto.getTotalCount())
                .anger(responseDto.getAnger())
                .disgust(responseDto.getDisgust())
                .fear(responseDto.getFear())
                .joy(responseDto.getJoy())
                .love(responseDto.getLove())
                .sad(responseDto.getSad())
                .build();
    }
}
