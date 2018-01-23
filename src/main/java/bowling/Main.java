package bowling;

import bowling.domain.BowlingGame;
import bowling.view.InputView;

public class Main {
    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame(InputView.getPlayer());
        while(!bowlingGame.isEnd()) {

        }
    }
}
