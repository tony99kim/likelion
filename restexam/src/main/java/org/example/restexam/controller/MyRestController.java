package org.example.restexam.controller;

import org.example.restexam.dto.User;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class MyRestController {
    @GetMapping("/hi")
    public String hi() {
        return "마 반갑다이 나는 rest controller 다 ";
    }

    @GetMapping("/greeting")
    public Map<String,String> greet(@RequestParam(name = "name",required = false,defaultValue = "kim")String name) {
        Map<String, String> response = new HashMap<>();
        response.put("name",name);
        return response;
    }

//    @GetMapping("/users")
//    public User createUser(@ModelAttribute User user) {
//        user.setId(1L);
//        user.setCreateAt(LocalDateTime.now());
//        return user;
//    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        user.setId(1L);
        user.setCreateAt(LocalDateTime.now());
        return user;
    }
}
