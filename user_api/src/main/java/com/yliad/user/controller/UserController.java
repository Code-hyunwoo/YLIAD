package com.yliad.user.controller;

import com.yliad.user.dto.request.SaveBgmSettingRequestDto;
import com.yliad.user.dto.request.SaveFontSettingRequestDto;
import com.yliad.user.dto.request.SaveThemeSettingRequestDto;
import com.yliad.user.dto.request.SaveUserRequestDto;
import com.yliad.user.service.UserService;
//import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
//    @ApiOperation(value = "회원 가입")
    public ResponseEntity<Void> save(@RequestBody SaveUserRequestDto requestDto){
        service.saveUser(requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
//    @ApiOperation(value = "회원 탈퇴")
    public ResponseEntity<Void> delete(@RequestBody Long userId) {
        service.delete(userId);
        return ResponseEntity.status(200).build();
    }

    @GetMapping("/signup/id/{loginid}")
//    @ApiOperation(value = "로그인아이디 중복체크")
    public ResponseEntity<Void> checkLoginId(@PathVariable("loginid") String loginid) {
        service.checkDuplicateUserLoginId(loginid);
        return ResponseEntity.status(200).build();
    }

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
