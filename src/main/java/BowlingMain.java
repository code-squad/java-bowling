import domain.BowlingGame;
import domain.Player;
import jdk.internal.util.xml.impl.Input;
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
        List<Player> players = bowlingGame.createPlayer(InputView.getUserName(scanner, InputView.getUserCount(scanner)));

        ResultView.printScoreBoard(players);
        for (int index = 1; index < 11; index++) {
            for (Player player : players) {
                while(!bowlingGame.isEndFrame(player)) {
                    bowlingGame.bowl(player, InputView.getThrowing(scanner, player.getName()));
                    ResultView.printScoreBoard(players);
                }
                if (index < 10) {
                    bowlingGame.nextFrame(player);
                }
            }
        }
    }
}
