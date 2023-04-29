package com.example.wihao.service.loan;

import com.example.wihao.domain.book.Book;
import com.example.wihao.domain.loan.Loan;
import com.example.wihao.domain.user.User;
import com.example.wihao.dto.loan.LoanResponseDto;
import com.example.wihao.exception.BookNotFoundException;
import com.example.wihao.exception.LoanAlreadyExistsException;
import com.example.wihao.exception.LoanNotFoundException;
import com.example.wihao.repository.book.BookRepository;
import com.example.wihao.repository.loan.LoanRepository;
import com.example.wihao.utils.LoanStatus;
import com.example.wihao.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;

    @Transactional
    public LoanResponseDto create(String ISBN, User user) {
        Book book = bookRepository.findByISBNAndStatus(ISBN, Status.ACTIVE).orElseThrow(BookNotFoundException::new);

        if (loanRepository.existsLoansByBook(book)) {
            throw new LoanAlreadyExistsException();
        }

        Loan loan = Loan.builder()
                .user(user)
                .book(book).build();
        loanRepository.save(loan);

        return LoanResponseDto.of(loan);
    }

    @Transactional
    public LoanResponseDto returnBook(String ISBN) {
        Book book = bookRepository.findByISBNAndStatus(ISBN, Status.ACTIVE).orElseThrow(BookNotFoundException::new);
        Loan loan = loanRepository.findByBookAndLoanStatus(book, LoanStatus.RENTAL).orElseThrow(LoanNotFoundException::new);
        loan.returnBook();
        return LoanResponseDto.of(loan);
    }

    public List<LoanResponseDto> getRentalByUser(User user) {
        List<Loan> loans = loanRepository.findByUserAndLoanStatus(user, LoanStatus.RENTAL);
        return loans.stream().map(LoanResponseDto::of).collect(Collectors.toList());
    }

    public List<LoanResponseDto> getReturnByUser(User user) {
        List<Loan> loans = loanRepository.findByUserAndLoanStatus(user, LoanStatus.RETURN);
        return loans.stream().map(LoanResponseDto::of).collect(Collectors.toList());
    }
}
