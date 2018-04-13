package saru;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private int maxBallCount;
    private List<DownPin> downPins = new ArrayList<>();

    private Frame(int maxBallCount) {
        this.maxBallCount = maxBallCount;
    }

    public static Frame of(int maxBallCount) {
        return new Frame(maxBallCount);
    }

    void throwing(DownPin downPinCount) {
        if (!checkThrowingPossible()) {
            return;
        }

        downPins.add(downPinCount);
    }

    DownPin getNowDownPinCount() {
        return downPins.get(downPins.size() - 1);
    }

    boolean checkThrowingPossible() {
        if (getNowBallCount() == 0) {
            return true;
        }

        if (downPins.get(0).equals(DownPin.of(10))) {
            return false;
        }

        if (checkFull()) {
            return false;
        }

        return true;
    }

    private boolean checkFull() {
        return maxBallCount == getNowBallCount();
    }

    int getNowBallCount() {
        return downPins.size();
    }
}
