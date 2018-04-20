package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;
import bowling.domain.util.Formatter;

public class Player implements Printable {
    private final String name;
    private final Frame frame;

    public Player(String name) {
        this.name = name;
        this.frame = new NormalFrame(1);
    }

    public void bowl(int pins) {
        frame.bowl(pins);
    }

    @Override
    public String convertToPrintable() {
        return "|" + Formatter.formatFrame(name) + "|" + frame.toString();
    }

//    public boolean isDone() {
//        return frame.nextIsLastFrame();
//    }
}