package bowling;

import bowling.domain.BowlingGame;
import bowling.domain.Player;
import bowling.view.InputView;
import bowling.view.ScoreBoardView;

public class BowlingMain {

    public static void main(String[] args) {
        Player player = InputView.inputPlayer();
        BowlingGame bowlingGame = new BowlingGame();

        while(!bowlingGame.isEndGame()) {
            bowlingGame.throwBall(InputView.inputThrow(bowlingGame.getCurrentFrameNo()));
            ScoreBoardView.printScoreBoard(player, bowlingGame);
        }
    }
}
