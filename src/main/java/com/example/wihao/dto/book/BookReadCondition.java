package com.example.wihao.dto.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookReadCondition {
    private String ISBN;
    private String title;
    private String category;
    private String author;
    private String publisher;
}
