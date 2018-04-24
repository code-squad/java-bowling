package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;
import bowling.domain.util.Formatter;

public class Player implements Printable {
    private static final int FIRST = 1;
    private static final int INITIAL = 0;

    private final String name;
    private final Frame frames;

    public Player(String name) {
        this.name = name;
        this.frames = new NormalFrame(FIRST);
    }

    public void bowl(int pins) {
        frames.bowl(pins);
    }

    public boolean isDone() {
        return frames.isLast();
    }

    public int getCurrentFrameNumber() {
        return frames.getFrameNumber();
    }

    @Override
    public String convertStatusToPrintable() {
        return "|"
                + Formatter.formatFrame(name)
                + "|"
                + frames.getPrintableStatus();
    }

    @Override
    public String convertScoreToPrintable() {
        return "|"
                + Formatter.formatFrame("")
                + "|"
                + frames.getPrintableScore(INITIAL);
    }
}