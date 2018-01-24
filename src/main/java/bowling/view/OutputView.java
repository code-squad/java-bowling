package bowling.view;

import bowling.domain.Player;
import bowling.dto.Board;

import java.util.List;


public class OutputView {
    private static final String TOP_MESSAGE = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";

    public static void showScoreBoard(Board board) {
        System.out.println(TOP_MESSAGE);

        board.getPlayerResults()
                .forEach(result -> {
                    String name = result.getName();
                    List<String> frameView = result.getFrameViews();

                    System.out.print("|  " + name + " |");
                    frameView.forEach(view -> System.out.print("  " + view + " |"));
                });
        System.out.println();
    }

    public static void showPlayerTurnInfo(Board board) {
        System.out.print(board.getCurrentPlayerInfo().getCurrentFrameNo() + 1 + "프레임 투구 : ");
    }
}
