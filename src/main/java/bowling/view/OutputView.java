package bowling.view;

import bowling.dto.Board;


public class OutputView {
    private static final String TOP_MESSAGE = "| NAME |  01  |  02  |  03  |  04  |  05  |  06  |  07  |  08  |  09  |  10  |";

    public static void showScoreBoard(Board board) {
        System.out.println(TOP_MESSAGE);

        board.getPlayerResults()
                .forEach(result -> {
                    System.out.print("|  " + result.getName() + " |");
                    result.getFrameViews()
                            .forEach(view -> System.out.print("  " + view + " |"));
                    System.out.println();

                    System.out.print("|      |");
                    result.getScoreViews()
                            .forEach(score -> System.out.print("  " + score + " |"));
                    System.out.println();
                });
        System.out.println();
    }

    public static void showPlayerTurnInfo(Board board) {
        System.out.print(board.getCurrentPlayerInfo().getCurrentFrameNo() + 1 + "프레임 투구 : ");
    }
}
