package com.example.wihao.dto.post;

import com.example.wihao.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
    private String title;
    private String lectureName;
    private Integer rating;
    private String mentor;
    private String date;
    private String pros;
    private String cons;

    public static Post toEntity(PostRequestDto req) {
        return Post.builder()
                .title(req.getTitle())
                .pros(req.getPros())
                .date(req.getDate())
                .lectureName(req.getLectureName())
                .mentor(req.getMentor())
                .rating(req.getRating())
                .cons(req.getCons())
                .build();
    }
}
