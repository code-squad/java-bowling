package bowling.domain;

public class BowlingGame {
    private final Player player;

    public BowlingGame(String name){
        this.player = new Player(name);
    }
}