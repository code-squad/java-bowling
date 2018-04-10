import domain.Player;
import view.InputView;
import view.OutputView;

import static view.InputView.getScore;

public class BowlingMain {

    public static void main(String[] args) {
        Player player = InputView.getPlayer();
        while (!player.isFinish()) {
            doGame(player);
        }
    }

    private static void doGame(Player player) {
        try {
            player.recordPins(getScore(player.getCurrentFrameNum()));
            OutputView.printResult(player);
        } catch (IllegalArgumentException e) {
            InputView.printMessage(e.getMessage());
            doGame(player);
        }
    }
}
