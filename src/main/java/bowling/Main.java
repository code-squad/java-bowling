package bowling;

import bowling.domain.BowlingGame;
import bowling.view.InputView;
import bowling.view.OutputView;

public class Main {
    public static void main(String[] args) {
        BowlingGame bowlingGame = new BowlingGame(InputView.getPlayer());
        OutputView.showScoreBoard(bowlingGame.createBoard());

        while(!bowlingGame.isGameEnd()) {
            OutputView.showPlayerTurnInfo(bowlingGame.createBoard());
            bowlingGame.rollBowlingBall(InputView.getPin());
            OutputView.showScoreBoard(bowlingGame.createBoard());
        }
    }
}
