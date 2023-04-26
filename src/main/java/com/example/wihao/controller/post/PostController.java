package com.example.wihao.controller.post;

import com.example.wihao.dto.post.PostReadCondition;
import com.example.wihao.dto.post.PostRequestDto;
import com.example.wihao.dto.post.PostResponseDto;
import com.example.wihao.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/posts")
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody PostRequestDto req) {
        postService.create(req);
        return ResponseEntity.ok("정상");
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> readAll() {
        return ResponseEntity.ok(postService.readAll());
    }

    @GetMapping("/condition")
    public ResponseEntity<List<PostResponseDto>> readAllByCondition(
           @RequestBody PostReadCondition condition
    ) {
        return ResponseEntity.ok(postService.readAllByCondition(condition));
    }

}
