package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;
import bowling.domain.util.Formatter;

public class Player {
    private static final int FIRST = 1;
    private static final int INITIAL = 0;

    private final String name;
    private final Frame headFrame;

    Player(String name) {
        this.name = name;
        this.headFrame = new NormalFrame(FIRST);
    }

    public void bowl(int pins) {
        headFrame.bowl(pins);
    }

    boolean turnIsOver() {
        return headFrame.isNewFrame();
    }

    boolean hasPlayedAllBowls() {
        return headFrame.isLastFrame()
                && headFrame.isNewFrame();
    }

    String convertStatusToPrintable() {
        return "|"
                + Formatter.formatFrame(name)
                + "|"
                + headFrame.getPrintableStatus();
    }

    String convertScoreToPrintable() {
        return "|"
                + Formatter.formatFrame("")
                + "|"
                + headFrame.getPrintableScore(INITIAL);
    }

    String getPlayerName() {
        return name;
    }
}