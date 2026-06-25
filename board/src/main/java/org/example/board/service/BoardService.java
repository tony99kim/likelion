package org.example.board.service;

import lombok.RequiredArgsConstructor;
import org.example.board.domain.Board;
import org.example.board.dto.BoardRequestDto;
import org.example.board.dto.BoardResponseDto;
import org.example.board.exception.BoardNotFoundException;
import org.example.board.exception.PasswordMismatchException;
import org.example.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardResponseDto> getBoardList() {
        List<BoardResponseDto> boards = StreamSupport.stream(boardRepository.findAll().spliterator(), false)
                .sorted(Comparator.comparing(Board::getId).reversed())
                .map(BoardResponseDto::from)
                .toList();

        for (int i = 0; i < boards.size(); i++) {
            boards.get(i).setDisplayNumber(boards.size() - i);
        }

        return boards;
    }

    public BoardResponseDto getBoard(Long id) {
        List<BoardResponseDto> boards = getBoardList();

        return boards.stream()
                .filter(board -> board.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BoardNotFoundException(id));
    }

    @Transactional
    public Long createBoard(BoardRequestDto dto) {
        LocalDateTime now = LocalDateTime.now();

        Board board = new Board();
        board.setName(dto.getName());
        board.setTitle(dto.getTitle());
        board.setPassword(dto.getPassword());
        board.setContent(dto.getContent());
        board.setCreatedAt(now);
        board.setUpdatedAt(now);

        Board savedBoard = boardRepository.save(board);

        return savedBoard.getId();
    }

    @Transactional
    public void updateBoard(Long id, BoardRequestDto dto) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id));

        if (!board.isPasswordCorrect(dto.getPassword())) {
            throw new PasswordMismatchException();
        }

        board.update(dto.getName(), dto.getTitle(), dto.getContent());

        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Long id, String password) {
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new BoardNotFoundException(id));

        if (!board.isPasswordCorrect(password)) {
            throw new PasswordMismatchException();
        }

        boardRepository.deleteById(id);
    }
}