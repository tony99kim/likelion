package org.example.aopexam.afteraop;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    public void addUser() {

        System.out.println("User를 추가하기 위한 코드1");
        System.out.println("User를 추가하기 위한 코드2");
        System.out.println("User를 추가하기 위한 코드3");
        System.out.println("User를 추가하기 위한 코드4");
        System.out.println("User를 추가하기 위한 코드5");

    }

    public void updateUser() {
        System.out.println("User를 수정하기 위한 코드1");
        System.out.println("User를 수정하기 위한 코드2");
        System.out.println("User를 수정하기 위한 코드3");
        System.out.println("User를 수정하기 위한 코드4");
        System.out.println("User를 수정하기 위한 코드5");
    }
}
