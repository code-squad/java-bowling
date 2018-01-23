package bowling.view;

import bowling.domain.Player;
import bowling.domain.Players;

import java.util.List;


public class OutputView {
    private static final String TOP_MESSAGE = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";

    public static void showScoreBoard(Players players) {
        System.out.println(TOP_MESSAGE);

        players.getPlayersAsList()
                .forEach(player -> {
                    String name = player.getName();
                    List<String> frameView = player.getFrameViews();

                    System.out.print("|  " + name + " |");
                    frameView.forEach(view -> System.out.print("  " + view + " |"));
                });
        System.out.println();
    }

    public static void showPlayerTurnInfo(Player currentPlayer) {
        currentPlayer.printFrameInfo();
    }
}
