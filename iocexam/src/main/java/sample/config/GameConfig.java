package sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import sample.bean.Dice;
import sample.bean.Game;
import sample.bean.Player;

import java.util.List;

@PropertySource({"classpath:dice.properties"})
public class GameConfig {
    @Value("${face}")
    int face;

    @Bean
    public Dice dice() {
        return new Dice(face);
    }

//    @Bean
//    public Player kang() {
//        Player player = new Player();
//        player.setName("kang");
//        return player;
//    }

    @Bean
    public Player kang(Dice dice) {
//        Player player = new Player();
//        player.setName("kang");
//        player.setDice(dice);
//          return player;
        return new Player("kang",dice);
    }

    @Bean
    public Player lee(Dice dice) {
        Player player = new Player();
        player.setName("lee");
        player.setDice(dice);
        return player;
    }

    @Bean
    public Player park(Dice dice) {
        Player player = new Player();
        player.setName("park");
        player.setDice(dice);
        return player;
    }

    @Bean
    public Game game(List<Player> players) {
        Game game = new Game();
        game.setList(players);
        return game;
    }
}
