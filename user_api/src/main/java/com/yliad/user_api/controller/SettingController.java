package com.yliad.user_api.controller;

import com.yliad.user_api.dto.request.SaveBgmSettingRequestDto;
import com.yliad.user_api.dto.request.SaveFontSettingRequestDto;
import com.yliad.user_api.dto.request.SaveThemeSettingRequestDto;
import com.yliad.user_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/setting")
@RequiredArgsConstructor
public class SettingController {

    private final UserService service;

    @PatchMapping("/bgm")
//    @ApiOperation(value = "Bgm 수정")
    public ResponseEntity<Void> changeBgm(@RequestBody SaveBgmSettingRequestDto requestDto) {
        service.changeBgm(requestDto.getUserId(), requestDto.getBgmName());
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/font")
//    @ApiOperation(value = "Font 수정")
    public ResponseEntity<Void> changeFont(@RequestBody SaveFontSettingRequestDto requestDto) {
        service.changeFont(requestDto.getUserId(), requestDto.getFontName());
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/theme")
//    @ApiOperation(value = "Theme 수정")
    public ResponseEntity<Void> changeTheme(@RequestBody SaveThemeSettingRequestDto requestDto) {
        service.changeTheme(requestDto.getUserId(), requestDto.getThemeName());
        return ResponseEntity.status(200).build();
    }
}
