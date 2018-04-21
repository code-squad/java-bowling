package bowling;

import bowling.domain.BowlingGame;
import bowling.view.InputView;

import java.util.Scanner;

public class BowlingApplication {

    public static void main(String[] args) {
        String playerName = InputView.inputPlayerName();
        BowlingGame bowlingGame = new BowlingGame(playerName);

        bowlingGame.play(() -> {
            Scanner scanner = new Scanner(System.in);
            return scanner.nextInt();
        });
    }
}
