package org.example.restapitask.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.restapitask.domain.User;
import org.example.restapitask.dto.CommentDto;
import org.example.restapitask.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentDto.Response createComment(
            @Valid @RequestBody CommentDto.CreateRequest request,
            @AuthenticationPrincipal User currentUser
    ) {
        return commentService.createComment(request, currentUser);
    }

    @GetMapping
    public List<CommentDto.Response> getCommentsByPostId(@RequestParam Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(
            @PathVariable Long id,
            @AuthenticationPrincipal User currentUser
    ) {
        commentService.softDeleteComment(id, currentUser);
    }
}