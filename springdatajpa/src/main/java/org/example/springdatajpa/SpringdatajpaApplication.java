package org.example.springdatajpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;


@SpringBootApplication
public class SpringdatajpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(UserRepository repository,UserService service){
        return args -> {
            service.addUser(new User("John Doe", "john.doe@example.com"));
          User user = new User("John Doe", "john.doe@example.com");
          repository.save(user);

            Optional<User> user1 = repository.findById(1L);

            User guestUser = user1.orElse(new User("Guest", "guest@example.com"));

//            if(user != null){
//                System.out.println(user.getName());
//            }




        };
    }
}
