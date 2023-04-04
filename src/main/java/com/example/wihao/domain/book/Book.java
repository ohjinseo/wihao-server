package com.example.wihao.domain.book;

import com.example.wihao.utils.Status;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Book {
    @Id
    private String ISBN;

    private String title;

    private String category;

    private String author;

    private String publisher;

    private int issueYear;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    public void prePersist() {
        this.ISBN = UUID.randomUUID().toString();
    }

    @Builder
    public Book(String title, String category, String author, String publisher, int issueYear) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
        this.issueYear = issueYear;
    }
}
