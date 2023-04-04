package com.example.wihao.config.batch;

import com.example.wihao.domain.book.Book;
import com.example.wihao.dto.book.BookDto;
import com.example.wihao.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class CsvWriter implements ItemWriter<BookDto> {

    private final BookRepository bookRepository;

    @Transactional
    @Override
    public void write(Chunk<? extends BookDto> chunk) throws Exception {
        System.out.println(chunk);
        log.info(chunk.getItems().toString());
        List<Book> bookList = new ArrayList<>();

        chunk.getItems().forEach(getBook -> {
            Book book = Book.builder()
                    .title(getBook.getTitle())
                    .author(getBook.getAuthor())
                    .category(getBook.getCategory())
                    .issueYear(getBook.getIssueYear())
                    .publisher(getBook.getPublisher())
                    .build();
            bookList.add(book);
        });

        bookRepository.saveAll(bookList);
    }
}