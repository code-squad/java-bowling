import domain.player.Players;
import view.InputView;
import view.OutputView;

import static view.InputView.*;

public class BowlingMain {

    public static void main(String[] args) {
        Players players = getPlayers(getPlayerNum());
        while (!players.isFinish()) {
            doGame(players);
        }
    }

    private static void doGame(Players players) {
        try {
            players.roll(getPinNum(players.getCurrentPlayer()));
            OutputView.printBoards(players);
        } catch (IllegalArgumentException e) {
            InputView.printMessage(e.getMessage());
            doGame(players);
        }
    }
}
