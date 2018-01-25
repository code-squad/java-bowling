package bowling.view;

import bowling.domain.BowlingGame;
import bowling.domain.Frame;
import bowling.domain.Player;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScoreBoardView {

    public static void printScoreBoard(Player player, BowlingGame bowlingGame) {
        System.out.println(getScoreboardHeaderStr());
        System.out.println(getFrameInfo(player, bowlingGame));
    }

    private static String getScoreboardHeaderStr() {
        return "| Name " +
                IntStream.rangeClosed(1, 10)
                        .boxed()
                        .map(i -> String.format("  %02d  ", i))
                        .collect(Collectors.joining("|", "|", "|"));
    }

    private static String getFrameInfo(Player player, BowlingGame bowlingGame) {
        return String.format("|  %s ", player.getName()) +
                bowlingGame.getFrames().stream()
                        .map(Frame::getFrameInfoWithFormat)
                        .collect(Collectors.joining("|", "|", "|"));
    }
}
