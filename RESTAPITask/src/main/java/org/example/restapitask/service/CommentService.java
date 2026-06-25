package org.example.restapitask.service;

import lombok.RequiredArgsConstructor;
import org.example.restapitask.domain.Comment;
import org.example.restapitask.domain.Post;
import org.example.restapitask.domain.User;
import org.example.restapitask.dto.CommentDto;
import org.example.restapitask.exception.CommentNotFoundException;
import org.example.restapitask.exception.PostNotFoundException;
import org.example.restapitask.repository.CommentRepository;
import org.example.restapitask.repository.PostRepository;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public CommentDto.Response createComment(CommentDto.CreateRequest request, User currentUser) {
        Post post = postRepository.findById(request.postId())
                .orElseThrow(() -> new PostNotFoundException(request.postId()));

        Comment comment = Comment.builder()
                .content(request.content())
                .post(post)
                .user(currentUser)
                .build();

        Comment savedComment = commentRepository.save(comment);

        return CommentDto.Response.from(savedComment);
    }

    public List<CommentDto.Response> getCommentsByPostId(Long postId) {
        if (!postRepository.existsById(postId)) {
            throw new PostNotFoundException(postId);
        }

        return commentRepository.findByPostIdAndDelYnFalseOrderByRegdateAsc(postId)
                .stream()
                .map(CommentDto.Response::from)
                .toList();
    }

    @Transactional
    public void softDeleteComment(Long id, User currentUser) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new CommentNotFoundException(id));

        boolean isAuthor = comment.isAuthor(currentUser);
        boolean isAdmin = currentUser.hasRole("ADMIN");

        if (!isAuthor && !isAdmin) {
            throw new AccessDeniedException("본인의 댓글만 삭제할 수 있습니다.");
        }

        comment.softDelete();
    }
}