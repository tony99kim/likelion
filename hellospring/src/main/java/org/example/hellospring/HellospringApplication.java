package org.example.hellospring;

import org.example.hellospring.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class HellospringApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellospringApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "Hello Spring";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hi spring";
    }

    @GetMapping("/선우는춘식이")
    public String 선우는춘식이() {
        return "선우는춘식이";
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return name + "님 안녕하세요!";
    }

    @GetMapping("/add")
    public int add(@RequestParam int a,
                   @RequestParam int b) {

        return a + b;
    }

    @GetMapping("/test")
    public Map<String, Integer> test() {

        Map<String, Integer> map = new HashMap<>();
        map.put("result", 30);

        return map;
    }


    @GetMapping("/time")
    public String time() {
        return LocalDateTime.now().toString();
    }

}
