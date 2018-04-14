import domain.Player;
import view.InputView;
import view.OutputView;

import static view.InputView.getPinNum;

public class BowlingMain {

    public static void main(String[] args) {
        Player player = InputView.getPlayer();
        while (!player.isFinish()) {
            doGame(player);
        }
    }

    private static void doGame(Player player) {
        try {
            player.roll(getPinNum(player.getCurrentFrameNum()));
            OutputView.printBoard(player);
        } catch (IllegalArgumentException e) {
            InputView.printMessage(e.getMessage());
            doGame(player);
        }
    }
}
