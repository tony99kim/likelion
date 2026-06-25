package org.example.beforesecurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {
    @GetMapping("/api/hello")
    public String hello() {
        log.info("hello() 실행이다 마!");
        System.out.println("hello() 실행이다 마!");
        return "hello";
    }

    @GetMapping("/api/hi")
    public String hi() {
        log.info("hi() 실행이다 마!");
        System.out.println("hi() 실행이다 마!");
        return "hi";
    }
}
