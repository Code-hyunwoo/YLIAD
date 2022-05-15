package com.yliad.diary.controller;

import com.yliad.diary.dto.request.DiaryRequestDto;
import com.yliad.diary.dto.request.SaveDiaryRequestDto;
import com.yliad.diary.dto.response.MyPageResponseDto;
import com.yliad.diary.service.DiaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/diary")
@RequiredArgsConstructor
public class DiaryController {

    private final DiaryService service;

    @PostMapping
//    @ApiOperation(value = "일기 작성")
    public ResponseEntity<Void> saveDiary(@RequestBody SaveDiaryRequestDto requestDto){
        service.saveDiary(requestDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mypage")
//    @ApiOperation(value = "마이페이지")
    public ResponseEntity<MyPageResponseDto> checkMyPage (@RequestBody DiaryRequestDto requestDto){
        MyPageResponseDto responseDto = service.getMyPage(requestDto.getUserID(), requestDto.getCurrentTime());
        return ResponseEntity.status(200).body(responseDto);
    }

}
