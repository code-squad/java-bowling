package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;
import bowling.domain.util.Formatter;

public class Player implements Printable{
    private final String name;
    private final Frame initialFrame;
    private Frame currentFrame;

    public Player(String name) {
        this.name = name;
        this.initialFrame = new NormalFrame(1);
    }

    public void bowl(int pins) {
        Frame newFrame = currentFrame.bowl(pins);
        if (newFrame != null) {
            currentFrame = newFrame;
        }
    }

    public boolean isDone() {
        return currentFrame.isLast();
    }

    @Override
    public String convertStatusToPrintable() {
        return "|" + Formatter.formatFrame(name) + "|" + initialFrame.convertStatusToPrintable();
    }

    @Override
    public String convertScoreToPrintable() {
        return initialFrame.convertScoreToPrintable();
    }
}