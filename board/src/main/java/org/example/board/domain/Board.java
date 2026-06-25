package org.example.board.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("board")
public class Board {

    @Id
    private Long id;
    private String name;
    private String title;
    private String password;
    private String content;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public boolean isPasswordCorrect(String inputPassword) {
        return password != null && password.equals(inputPassword);
    }

    public void update(String name, String title, String content){
        this.name = name;
        this.title = title;
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }


}
