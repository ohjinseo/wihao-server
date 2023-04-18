package com.example.wihao.repository.loan;

import com.example.wihao.domain.loan.Loan;
import com.example.wihao.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUser(User user);
}

