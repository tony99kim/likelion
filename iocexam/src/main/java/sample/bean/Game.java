package sample.bean;

import java.util.List;

public class Game {
    private List<Player> list;

    public void play()
    {
        for(Player player : list){
            player.play();
        }
    }

    public void setList(List<Player> players) {
        this.list = players;
    }

    public List<Player> getList() {
        return list;
    }

}
