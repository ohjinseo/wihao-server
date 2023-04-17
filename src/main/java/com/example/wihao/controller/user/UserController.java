package com.example.wihao.controller.user;

import com.example.wihao.config.security.JwtTokenProvider;
import com.example.wihao.dto.user.LoginRequestDto;
import com.example.wihao.dto.user.LoginResponseDto;
import com.example.wihao.dto.user.SignUpRequestDto;
import com.example.wihao.repository.user.UserRepository;
import com.example.wihao.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/sign")
    public ResponseEntity signUp(@RequestBody SignUpRequestDto req) {
        userService.signUp(req);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto req) {
        return ResponseEntity.ok(userService.login(req));
    }
}
