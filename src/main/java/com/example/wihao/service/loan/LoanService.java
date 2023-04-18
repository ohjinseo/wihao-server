package com.example.wihao.service.loan;

import com.example.wihao.domain.book.Book;
import com.example.wihao.domain.loan.Loan;
import com.example.wihao.domain.user.User;
import com.example.wihao.dto.loan.LoanResponseDto;
import com.example.wihao.exception.BookNotFoundException;
import com.example.wihao.repository.book.BookRepository;
import com.example.wihao.repository.loan.LoanRepository;
import com.example.wihao.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    public LoanResponseDto create(String ISBN, User user) {
        Book book = bookRepository.findByISBNAndStatus(ISBN, Status.ACTIVE).orElseThrow(BookNotFoundException::new);

        Loan loan = Loan.builder()
                .user(user)
                .book(book).build();
        loanRepository.save(loan);

        return LoanResponseDto.of(loan);
    }
}
