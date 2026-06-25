package org.example.restapitask.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.restapitask.domain.Comment;

import java.time.LocalDateTime;

public class CommentDto {

    public record CreateRequest(
            @NotBlank String content,
            @NotNull Long postId
    ) {
    }

    public record Response(
            Long id,
            String content,
            boolean delYn,
            LocalDateTime regdate,
            Long postId,
            UserDto.SimpleResponse user
    ) {
        public static Response from(Comment comment) {
            return new Response(
                    comment.getId(),
                    comment.getContent(),
                    comment.isDelYn(),
                    comment.getRegdate(),
                    comment.getPost().getId(),
                    UserDto.SimpleResponse.from(comment.getUser())
            );
        }
    }
}