package sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import sample.bean.Book;
import sample.bean.Dice;
import sample.bean.MyBean;

@PropertySource({"classpath:dice.properties"})
public class MyBeanConfig {
    //<baen id = "myBean class="sample.bean.MyBean"></bean>

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyBean myBean2() {
        return new MyBean();
    }

    @Bean
    @Scope("prototype")
    public MyBean myBean3() {
        return new MyBean();
    }

    @Bean
    public Book book() {
        Book book = new Book();
        book.setTitle("Spring Boot");
        return book;
    }

    @Bean
    public Dice dice() {
        return new Dice();
    }

    @Bean
    public Dice dice2() {
        return new Dice(45);
    }

    @Bean
    public Dice dice3(@Value("${face}") int face) {
        return new Dice(face);
    }

    @Bean
    public Dice dice4(@Value("${face}") int face) {
        Dice dice = new Dice(face);
        dice.setFace(face);
        return dice();
    }

}
