package org.example.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.example.board.domain.Board;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@Builder
public class BoardResponseDto {

    private Long id;
    private Integer displayNumber;
    private String name;
    private String title;
    private String content;
    private String createdAt;
    private String updatedAt;

    public static BoardResponseDto from(Board board) {
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy/MM/dd");

        return BoardResponseDto.builder()
                .id(board.getId())
                .name(board.getName())
                .title(board.getTitle())
                .content(board.getContent())
                .createdAt(board.getCreatedAt() != null ? board.getCreatedAt().format(formatter) : "")
                .updatedAt(board.getUpdatedAt() != null ? board.getUpdatedAt().format(formatter) : "")
                .build();
    }
}
