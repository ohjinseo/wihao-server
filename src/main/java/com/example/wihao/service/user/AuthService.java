package com.example.wihao.service.user;

import com.example.wihao.config.security.JwtTokenProvider;
import com.example.wihao.domain.user.User;
import com.example.wihao.dto.user.LoginRequestDto;
import com.example.wihao.dto.user.LoginResponseDto;
import com.example.wihao.dto.user.SignUpRequestDto;
import com.example.wihao.exception.UserNameAlreadyExistsException;
import com.example.wihao.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public void signUp(SignUpRequestDto req) {
        validateSignUp(req);

        String encodedPassword = passwordEncoder.encode(req.getPassword());

        User user = User.builder().username(req.getUsername())
                .password(encodedPassword)
                .name(req.getName()).build();

        userRepository.save(user);
    }

    private void validateSignUp(SignUpRequestDto req) {
        if (userRepository.existsByUsername(req.getUsername())) {
            throw new UserNameAlreadyExistsException();
        }
    }

    public LoginResponseDto login(LoginRequestDto req) {
        User user = userRepository.findByUsername(req.getUsername());
        return LoginResponseDto.toDto(user.getId(), jwtTokenProvider.createToken(user.getUsername()));
    }
}



