package org.example.restapitask.repository;

import org.example.restapitask.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPostIdAndDelYnFalseOrderByRegdateAsc(Long postId);
}