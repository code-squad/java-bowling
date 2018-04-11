package saru;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private static final int NORMAL_COUNT = 2;
    private static final int LAST_COUNT = 3;
    private int maxThrowTimes;

    private List<DownPin> downPins = new ArrayList<>();

    private Frame(int maxThrowTimes) {
        this.maxThrowTimes = maxThrowTimes;
    }

    public static Frame of(int ballCount) {
        if (ballCount != NORMAL_COUNT && ballCount != LAST_COUNT) {
            throw new IllegalArgumentException("볼카운트가 잘못됨");
        }

        return new Frame(ballCount);
    }

    public int getNowThrowTimes() {
        return downPins.size();
    }

    public void throwing(DownPin pinCount) {
        downPins.add(pinCount);
    }

    DownPin getThrowResult() {
        return downPins.get(downPins.size() - 1);
    }
}
