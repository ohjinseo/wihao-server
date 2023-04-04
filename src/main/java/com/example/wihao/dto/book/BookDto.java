package com.example.wihao.dto.book;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private String category;
    private String title;
    private String author;
    private int issueYear;
    private String publisher;
}
