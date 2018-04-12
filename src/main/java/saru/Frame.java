package saru;

import java.util.*;

public class Frame {
    private static final int NORMAL_COUNT = 2;
    private static final int LAST_COUNT = 3;
    private List<DownPin> downPins = new ArrayList<>();

    private int maxBallCount;

    private Frame(int maxBallCount) {
        this.maxBallCount = maxBallCount;
    }

    public static Frame of(int maxBallCount) {
        if (maxBallCount != NORMAL_COUNT && maxBallCount != LAST_COUNT) {
            throw new IllegalArgumentException("볼카운트가 잘못됨");
        }

        return new Frame(maxBallCount);
    }

    public int getMaxBallCount() {
        return maxBallCount;
    }

    public int getNowBallCount() {
        return downPins.size();
    }

    public void throwing(DownPin downPinCount) {
        downPins.add(downPinCount);
    }

    DownPin getNowDownPinCount() {
        return downPins.get(downPins.size() - 1);
    }

    DownPin getFirstDownPinCount() {
        return downPins.get(0);
    }

    DownPin getSecondDownPinCount() {
        return downPins.get(1);
    }

    public boolean checkFull() {
        return maxBallCount == downPins.size();
    }
}
