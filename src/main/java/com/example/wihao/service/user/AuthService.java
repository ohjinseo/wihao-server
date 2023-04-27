package com.example.wihao.service.user;

import com.example.wihao.config.security.JwtTokenProvider;
import com.example.wihao.domain.loan.Loan;
import com.example.wihao.domain.user.User;
import com.example.wihao.dto.user.LoginRequestDto;
import com.example.wihao.dto.user.LoginResponseDto;
import com.example.wihao.dto.user.SignUpRequestDto;
import com.example.wihao.dto.user.UserResponseDto;
import com.example.wihao.exception.UserNameAlreadyExistsException;
import com.example.wihao.repository.loan.LoanRepository;
import com.example.wihao.repository.user.UserRepository;
import com.example.wihao.utils.LoanStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    private final LoanRepository loanRepository;

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
        List<Loan> loans = loanRepository.findByUserAndLoanStatus(user, LoanStatus.RENTAL);

        return LoginResponseDto.toDto(user.getId(), jwtTokenProvider.createToken(user.getUsername()), UserResponseDto.of(loans, user));
    }
}



