package com.example.wihao.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private Long userId;
    private String jwt;

    private UserResponseDto userResponseDto;

    public static LoginResponseDto toDto(Long userId, String jwt, UserResponseDto userResponseDto) {
        return new LoginResponseDto(userId, jwt, userResponseDto);
    }
}
