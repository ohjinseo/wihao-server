package com.example.wihao.dto.loan;

import com.example.wihao.domain.book.Book;
import com.example.wihao.domain.loan.Loan;
import com.example.wihao.dto.book.BookResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class LoanResponseDto {
    private BookResponseDto bookResponseDto;

    private LocalDateTime borrowDate;

    private LocalDateTime returnDate;

    public static LoanResponseDto of(
            Loan loan
    ) {
        return new LoanResponseDto(BookResponseDto.toDto(loan.getBook()), loan.getBorrowDate(), loan.getReturnDate());
    }
}
