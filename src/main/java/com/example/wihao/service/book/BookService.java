package com.example.wihao.service.book;

import com.example.wihao.domain.book.Book;
import com.example.wihao.dto.book.BookReadCondition;
import com.example.wihao.dto.book.BookRequestDto;
import com.example.wihao.dto.book.BookResponseDto;
import com.example.wihao.exception.BookNotFoundException;
import com.example.wihao.repository.book.BookRepository;
import com.example.wihao.utils.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookResponseDto read(String ISBN) {
        Book book = bookRepository.findByISBNAndStatus(ISBN, Status.ACTIVE).orElseThrow(BookNotFoundException::new);

        return BookResponseDto.toDto(book);
    }

    @Transactional
    public BookResponseDto create(BookRequestDto req) {
        Book book = bookRepository.save(BookRequestDto.toEntity(req));
        return BookResponseDto.toDto(book);
    }

    public List<BookResponseDto> readAllByCondition(BookReadCondition condition) {
        return bookRepository.findAllByCondition(condition);
    }
}
