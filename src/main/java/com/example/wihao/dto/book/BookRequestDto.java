package com.example.wihao.dto.book;

import com.example.wihao.domain.book.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
    private String title;
    private String category;
    private String author;
    private String publisher;
    private int issueYear;
    private String imgUrl;

    public static Book toEntity(BookRequestDto dto) {
        return Book.builder().title(dto.getTitle())
                .category(dto.getCategory())
                .author(dto.getAuthor())
                .publisher(dto.getPublisher())
                .issueYear(dto.getIssueYear())
                .imgUrl(dto.getImgUrl())
                .build();
    }
}
