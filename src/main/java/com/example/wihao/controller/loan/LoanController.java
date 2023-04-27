package com.example.wihao.controller.loan;

import com.example.wihao.domain.user.User;
import com.example.wihao.dto.loan.LoanResponseDto;
import com.example.wihao.service.loan.LoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/loans")
@RestController
public class LoanController {
    private final LoanService loanService;

    @PostMapping("/{ISBN}")
    public ResponseEntity<LoanResponseDto> create(@PathVariable String ISBN, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(loanService.create(ISBN, user));
    }

    @PatchMapping("/{ISBN}")
    public ResponseEntity<LoanResponseDto> returnBook(@PathVariable String ISBN) {
        return ResponseEntity.ok(loanService.returnBook(ISBN));
    }

    @GetMapping("/rentals")
    public ResponseEntity<List<LoanResponseDto>> getRentalByUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(loanService.getRentalByUser(user));
    }

    @GetMapping("/returns")
    public ResponseEntity<List<LoanResponseDto>> getReturnByUser(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(loanService.getReturnByUser(user));
    }
}
