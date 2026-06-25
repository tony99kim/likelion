package org.example.restapitask.dto;

import jakarta.validation.constraints.NotBlank;
import org.example.restapitask.domain.Post;

import java.time.LocalDateTime;

public class PostDto {

    public record CreateRequest(
            @NotBlank String title,
            @NotBlank String content
    ) {
    }

    public record UpdateRequest(
            @NotBlank String title,
            @NotBlank String content
    ) {
    }

    public record Response(
            Long id,
            String title,
            String content,
            LocalDateTime postedDate,
            UserDto.SimpleResponse user
    ) {
        public static Response from(Post post) {
            return new Response(
                    post.getId(),
                    post.getTitle(),
                    post.getContent(),
                    post.getPostedDate(),
                    UserDto.SimpleResponse.from(post.getUser())
            );
        }
    }
}