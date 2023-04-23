package com.example.wihao.repository.book;

import com.example.wihao.domain.book.Book;
import com.example.wihao.utils.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, String>, BookRepositoryCustom {
    Optional<Book> findByISBNAndStatus(String ISBN, Status active);
}
