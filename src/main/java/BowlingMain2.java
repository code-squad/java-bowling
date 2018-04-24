import domain.BowlingGame;
import domain.Player;
import state.Ready;
import state.State;
import view.InputView;
import view.ResultView2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BowlingMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BowlingGame bowlingGame = new BowlingGame();
        List<Player> players = bowlingGame.createPlayer(Arrays.asList(InputView.getUserName(scanner)));
        State currentState = new Ready();

        ResultView2.printScoreBoard(players, currentState);
        for (int index = 1; index < 11; index++) {
            while (!bowlingGame.isEndFrame()) {
                currentState = bowlingGame.bowl(InputView.getThrowing(scanner, index));
                ResultView2.printScoreBoard(players, currentState);
            }
            if (index < 10) {
                bowlingGame.nextFrame();
            }
        }
    }
}
