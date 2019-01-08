package bowling;

import bowling.service.BowlingGame;

public class Application {

    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.start();
    }
}
