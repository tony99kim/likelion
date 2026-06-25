package org.example.aopexam.afteraop;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class SimpleService {
    public void doSomething(){
        System.out.println("SimpleService의 doSomething run!!");
    }

    public String doSomething2(){
        System.out.println("SimpleService의 doSomething2 run!!");

//        if(1==1)
//            throw new RuntimeException();
        return "taeyeop";
    }

    public void hello(){
        System.out.println("hello");
    }
}
