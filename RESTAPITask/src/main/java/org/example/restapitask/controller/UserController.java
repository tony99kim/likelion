package org.example.restapitask.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.restapitask.domain.User;
import org.example.restapitask.dto.UserDto;
import org.example.restapitask.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto.Response createUser(@Valid @RequestBody UserDto.CreateRequest request) {
        return userService.createUser(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(
            @PathVariable Long id,
            @AuthenticationPrincipal User currentUser
    ) {
        userService.deleteUser(id, currentUser);
    }
}