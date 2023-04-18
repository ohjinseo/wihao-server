package com.example.wihao.service.user;

import com.example.wihao.domain.loan.Loan;
import com.example.wihao.domain.user.User;
import com.example.wihao.dto.user.UserResponseDto;
import com.example.wihao.repository.loan.LoanRepository;
import com.example.wihao.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    public UserResponseDto get(User user) {
        List<Loan> loans = loanRepository.findByUser(user);

        return UserResponseDto.of(loans, user);
    }
}
