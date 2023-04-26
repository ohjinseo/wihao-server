package com.example.wihao.service.post;

import com.example.wihao.domain.post.Post;
import com.example.wihao.dto.post.PostReadCondition;
import com.example.wihao.dto.post.PostRequestDto;
import com.example.wihao.dto.post.PostResponseDto;
import com.example.wihao.exception.PostNotFoundException;
import com.example.wihao.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void create(PostRequestDto req) {
        postRepository.save(PostRequestDto.toEntity(req));
    }

    public List<PostResponseDto> readAll() {
        return postRepository.findAll().stream().map(PostResponseDto::toDto).collect(Collectors.toList());
    }

    public List<PostResponseDto> readAllByCondition(PostReadCondition condition) {
        List<Post> posts;

        if (condition.getCategory().equals("강의명")) {
            posts = postRepository.findAllByLectureNameContaining(condition.getSearchValue());
        }else{
            posts = postRepository.findAllByMentorContaining(condition.getSearchValue());
        }

        return posts.stream().map(PostResponseDto::toDto).collect(Collectors.toList());
    }
}
