package bowling.domain;

import bowling.domain.frame.Frame;
import bowling.domain.frame.NormalFrame;

public class Player implements Printable {
    private final String name;
    private final Frame initialFrame;

    public Player(String name) {
        this.name = name;
        this.initialFrame = new NormalFrame(0);
    }

    public void bowl(int pins) {
        initialFrame.bowl(pins);
    }

    @Override
    public String convertToPrintable() {
        return initialFrame.toString();
    }
}