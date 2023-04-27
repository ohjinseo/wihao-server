package com.example.wihao.domain.loan;

import com.example.wihao.domain.book.Book;
import com.example.wihao.domain.user.User;
import com.example.wihao.utils.LoanStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;

    private LocalDateTime borrowDate;

    private LocalDateTime returnDate;

    @Builder
    public Loan(User user, Book book) {
        this.user = user;
        this.book = book;
        this.loanStatus = LoanStatus.RENTAL;
        this.borrowDate = LocalDateTime.now();
        this.returnDate = this.borrowDate.plusWeeks(2);
    }

    public void returnBook() {
        this.loanStatus = LoanStatus.RETURN;
    }
}
