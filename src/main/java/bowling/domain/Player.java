package bowling.domain;

import bowling.domain.frame.Frames;
import bowling.domain.util.Formatter;

public class Player implements Printable {
    private final String name;
    private final Frames frames;

    public Player(String name) {
        this.name = name;
        this.frames = new Frames();
    }

    public int getCurrentFrameNumber() {
        return frames.getCurrentFrameNumber();
    }

    public void bowl(int pins) {
        frames.bowl(pins);
    }

    public boolean isDone() {
        return frames.isDone();
    }

    @Override
    public String convertStatusToPrintable() {
        return "|" + Formatter.formatFrame(name) + "|" + frames.convertStatusToPrintable();
    }

    @Override
    public String convertScoreToPrintable() {
        return "|" + Formatter.formatFrame("") + "|" + frames.convertScoreToPrintable();
    }
}