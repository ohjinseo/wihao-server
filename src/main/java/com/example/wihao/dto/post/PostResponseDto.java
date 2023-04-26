package com.example.wihao.dto.post;

import com.example.wihao.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostResponseDto {
    private Long number;
    private String title;
    private String lectureName;
    private Integer rating;
    private String mentor;
    private String date;
    private String pros;
    private String cons;

    public static PostResponseDto toDto(Post post) {
        return new PostResponseDto(post.getNumber(), post.getTitle(), post.getLectureName(), post.getRating(), post.getMentor()
                , post.getDate(), post.getPros(), post.getCons());
    }
}
