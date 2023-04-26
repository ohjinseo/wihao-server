package com.example.wihao.domain.post;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    private String title;
    private String lectureName;
    private Integer rating;
    private String mentor;
    private String date;
    private String pros;
    private String cons;

    @Builder
    public Post(String title, String lectureName, Integer rating, String mentor, String date, String pros, String cons) {
        this.title = title;
        this.lectureName = lectureName;
        this.rating = rating;
        this.mentor = mentor;
        this.date = date;
        this.pros = pros;
        this.cons = cons;
    }
}
