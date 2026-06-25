package org.example.iocexam.controller;

import org.example.iocexam.service.UserService;

public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void joinUser() {
    }
}
