package com.example.wihao.dto.user;

import com.example.wihao.domain.loan.Loan;
import com.example.wihao.domain.user.User;
import com.example.wihao.dto.loan.LoanResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
public class UserResponseDto {
    private List<LoanResponseDto> loans;
    private String username;
    private String name;

    public static UserResponseDto of(List<Loan> loans, User user) {
        return new UserResponseDto(loans.stream().map(LoanResponseDto::of).collect(Collectors.toList()), user.getUsername(), user.getName());
    }
}
