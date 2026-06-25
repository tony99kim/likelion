package org.example.hellospring.controller;

import org.example.hellospring.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/list")
    public String list() {
        return "list";
    }

    @GetMapping("/user")
    public String getUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("1234");
        user.setPhone("010-2572-6034");
        user.setEmail("tony69kim@gmail.com");

        return user.toString();
    }
}
