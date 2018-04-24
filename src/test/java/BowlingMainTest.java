import domain.BowlingGame;
import domain.Player;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.ResultView2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BowlingMainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        BowlingGame bowlingGame = new BowlingGame(Arrays.asList("htw"));
        BowlingGame bowlingGame = new BowlingGame();
        List<Player> players = bowlingGame.createPlayer(Arrays.asList("htw"));

        for (int index = 1; index < 11; index++) {
            while (bowlingGame.isEndFrame()) {
                bowlingGame.bowl(InputView.getThrowing(scanner, index));
            }
        }

//        ResultView2.printScoreBoard(players);
    }
}
