package com.example.wihao.controller.book;

import com.example.wihao.dto.book.BookResponseDto;
import com.example.wihao.service.book.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/books")
@RestController
public class BookController {
    private final BookService bookService;

    @GetMapping("/{ISBN}")
    public ResponseEntity<BookResponseDto> read(@PathVariable String ISBN) {
        return ResponseEntity.ok(bookService.read(ISBN));
    }
}
