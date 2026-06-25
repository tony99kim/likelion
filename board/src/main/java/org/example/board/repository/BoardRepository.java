package org.example.board.repository;

import org.example.board.domain.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {


    Iterable<Board> findByTitleContaining(String title);

    Iterable<Board> findByNameContaining(String name);

}
