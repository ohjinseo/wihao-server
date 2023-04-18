package com.example.wihao.controller.user;

import com.example.wihao.domain.user.User;
import com.example.wihao.dto.user.UserResponseDto;
import com.example.wihao.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/users")
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponseDto> get(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(userService.get(user));
    }
}
