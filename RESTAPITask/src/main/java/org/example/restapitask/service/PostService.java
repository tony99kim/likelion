package org.example.restapitask.service;

import lombok.RequiredArgsConstructor;
import org.example.restapitask.domain.Post;
import org.example.restapitask.domain.User;
import org.example.restapitask.dto.PostDto;
import org.example.restapitask.exception.PostNotFoundException;
import org.example.restapitask.repository.PostRepository;
import org.springframework.data.domain.*;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostDto.Response createPost(PostDto.CreateRequest request, User currentUser) {
        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .user(currentUser)
                .build();

        Post savedPost = postRepository.save(post);

        return PostDto.Response.from(savedPost);
    }

    @Transactional
    public PostDto.Response updatePost(Long id, PostDto.UpdateRequest request, User currentUser) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        if (!post.isAuthor(currentUser)) {
            throw new AccessDeniedException("본인의 게시글만 수정할 수 있습니다.");
        }

        post.update(request.title(), request.content());

        return PostDto.Response.from(post);
    }

    @Transactional
    public void deletePost(Long id, User currentUser) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        boolean isAuthor = post.isAuthor(currentUser);
        boolean isAdmin = currentUser.hasRole("ADMIN");

        if (!isAuthor && !isAdmin) {
            throw new AccessDeniedException("게시글 삭제 권한이 없습니다.");
        }

        postRepository.delete(post);
    }

    public Page<PostDto.Response> getPosts(Pageable pageable) {
        Pageable sortedPageable = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "postedDate")
        );

        return postRepository.findAll(sortedPageable)
                .map(PostDto.Response::from);
    }

    public PostDto.Response getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        return PostDto.Response.from(post);
    }

    public Page<PostDto.Response> searchPosts(String keyword, Pageable pageable) {
        Pageable sortedPageable = PageRequest.of(
                pageable.getPageNumber(),
                pageable.getPageSize(),
                Sort.by(Sort.Direction.DESC, "postedDate")
        );

        return postRepository.findByTitleContainingIgnoreCase(keyword, sortedPageable)
                .map(PostDto.Response::from);
    }
}