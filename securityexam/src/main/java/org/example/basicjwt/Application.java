package org.example.basicjwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@Slf4j
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner run(JwtTokenizer jwtTokenizer) {
        return args -> {
            String accesToken = jwtTokenizer.createAccessToken(
                    1L,
                    "tony@gmail.com",
                    "김태엽",
                    "taeyeop",
                    Arrays.asList("ROLE_ADMIN","ROLE_USER")
            );

            log.info("accesToken : {}", accesToken);
            System.out.println("Hello World!");
        };
    }
}
