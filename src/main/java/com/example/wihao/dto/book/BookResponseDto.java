package com.example.wihao.dto.book;

import com.example.wihao.domain.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private String ISBN;
    private String title;
    private String category;
    private String author;
    private String publisher;
    private int issueYear;
    private String imgUrl;
    public static BookResponseDto toDto(Book book) {
        return new BookResponseDto(
                book.getISBN(),
                book.getTitle(),
                book.getCategory(),
                book.getAuthor(),
                book.getPublisher(),
                book.getIssueYear(),
                book.getImgUrl()
        );
    }
}
