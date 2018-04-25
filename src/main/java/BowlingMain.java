import domain.BowlingGame;
import domain.Player;
import state.Ready;
import state.State;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BowlingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BowlingGame bowlingGame = new BowlingGame();
        List<Player> players = bowlingGame.createPlayer(Arrays.asList(InputView.getUserName(scanner)));
        State currentState = new Ready();

        ResultView.printScoreBoard(players, currentState);
        for (int index = 1; index < 11; index++) {
            while (!bowlingGame.isEndFrame()) {
                currentState = bowlingGame.bowl(InputView.getThrowing(scanner, index));
                ResultView.printScoreBoard(players, currentState);
            }
            if (index < 10) {
                bowlingGame.nextFrame();
            }
        }
    }
}
