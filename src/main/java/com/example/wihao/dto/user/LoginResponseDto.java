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

    public static LoginResponseDto toDto(Long userId, String jwt) {
        return new LoginResponseDto(userId, jwt);
    }
}
