package com.example.wihao.controller.loan;

import com.example.wihao.domain.user.User;
import com.example.wihao.dto.loan.LoanResponseDto;
import com.example.wihao.service.loan.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/loans")
@RestController
public class LoanController {
    private final LoanService loanService;

    @PostMapping("/{ISBN}")
    public ResponseEntity<LoanResponseDto> create(@PathVariable String ISBN, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(loanService.create(ISBN, user));
    }
}
