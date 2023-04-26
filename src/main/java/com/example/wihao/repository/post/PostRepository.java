package com.example.wihao.repository.post;

import com.example.wihao.domain.post.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByLectureNameContaining(String lectureName);
    List<Post> findAllByMentorContaining(String mentor);
}
