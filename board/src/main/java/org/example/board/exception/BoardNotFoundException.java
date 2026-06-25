package org.example.board.exception;

public class BoardNotFoundException extends RuntimeException {

    public BoardNotFoundException(String message) {
        super(message);
    }

    public BoardNotFoundException(Long id) {
        super("게시글을 찾을 수 없습니다. id=" + id);
    }
}