package bowling.view;

import bowling.domain.LabelFrames;
import bowling.domain.Player;

public class ScoreBoard {
    private static final LabelFrames LABEL_FRAMES = new LabelFrames();

    public void printScoreBoard(Player player) {
        System.out.println(LABEL_FRAMES.toString());
        System.out.println(player.toString());
    }
}
