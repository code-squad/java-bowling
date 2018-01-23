import domain.Player;
import domain.Referee;
import view.ConsolePlayStrategy;
import view.ConsoleScoreBoard;

import static view.InputView.getPlayer;

public class Main {
    public static void main(String[] args) {
        Player player = getPlayer();

        ConsoleScoreBoard scoreBoard = new ConsoleScoreBoard(player);
        scoreBoard.printScoreBoard();
        Referee referee = new Referee(new ConsolePlayStrategy(), scoreBoard);

        referee.playBowling();
    }
}
