package bowling;

import bowling.domain.Player;
import bowling.io.InputView;
import bowling.io.OutPutView;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(InputView.playerName());
        play(player);
    }

    private static void play(Player player) {
        OutPutView.printScoreSheetGuideLine();
        OutPutView.printPlayerScoreSheet(player);
        System.out.println();
        while(player.needToRoll()) {
            player.roll(InputView.userPinDownCount(player.nextMaxCount(), player.currentFrame()));
            OutPutView.printScoreSheetGuideLine();
            OutPutView.printPlayerScoreSheet(player);
            System.out.println();
        }
    }
}