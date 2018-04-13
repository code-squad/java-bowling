import domain.Player;
import view.InputView;

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
            /*
                FrameResults results = player.makeResults();
                OutputView.printResult(results); 결과 객체를 넘겨야해
            */
        } catch (IllegalArgumentException e) {
            InputView.printMessage(e.getMessage());
            doGame(player);
        }
    }
}
