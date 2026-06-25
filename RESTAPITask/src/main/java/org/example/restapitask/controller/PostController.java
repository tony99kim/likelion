package org.example.restapitask.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.restapitask.domain.User;
import org.example.restapitask.dto.PostDto;
import org.example.restapitask.service.PostService;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto.Response createPost(
            @Valid @RequestBody PostDto.CreateRequest request,
            @AuthenticationPrincipal User currentUser
    ) {
        return postService.createPost(request, currentUser);
    }

    @PutMapping("/{id}")
    public PostDto.Response updatePost(
            @PathVariable Long id,
            @Valid @RequestBody PostDto.UpdateRequest request,
            @AuthenticationPrincipal User currentUser
    ) {
        return postService.updatePost(id, request, currentUser);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(
            @PathVariable Long id,
            @AuthenticationPrincipal User currentUser
    ) {
        postService.deletePost(id, currentUser);
    }

    @GetMapping
    public Page<PostDto.Response> getPosts(
            @PageableDefault(page = 0, size = 10) Pageable pageable
    ) {
        return postService.getPosts(pageable);
    }

    @GetMapping("/{id}")
    public PostDto.Response getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/search")
    public Page<PostDto.Response> searchPosts(
            @RequestParam String keyword,
            @PageableDefault(page = 0, size = 10) Pageable pageable
    ) {
        return postService.searchPosts(keyword, pageable);
    }
}