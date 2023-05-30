package com.example.wihao.repository.loan;

import com.example.wihao.domain.book.Book;
import com.example.wihao.domain.loan.Loan;
import com.example.wihao.domain.user.User;
import com.example.wihao.utils.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserAndLoanStatus(User user, LoanStatus loanStatus);
    Optional<Loan> findByBookAndLoanStatus(Book book, LoanStatus loanStatus);

    void deleteByBook(Book book);

    Boolean existsLoansByBook(Book book);
}

