package saru.domain;

import java.util.*;

public abstract class Frame {
    static final int MAX_DOWN_PIN = 10;
    static final int FIRST_INDEX = 0;
    static final int STRIKE = 10;

    List<DownPin> downPins = new ArrayList<>();
    private int maxBallCount;

    Frame(int maxBallCount) {
        this.maxBallCount = maxBallCount;
    }

    void throwing(DownPin downPin) {
        if (!checkThrowingPossible()) {
            return;
        }

        if (!downPins.isEmpty()) {
            checkValidThrowing(downPin);
        }

        downPins.add(downPin);
    }

    private void checkValidThrowing(DownPin downPin) {
        if (downPin.addWith(downPins.get(0)) > MAX_DOWN_PIN) {
            throw new IllegalArgumentException();
        }
    }

    DownPin getNowDownPin() {
        return downPins.get(downPins.size() - 1);
    }

    abstract boolean checkThrowingPossible();

    boolean checkFull() {
        return maxBallCount == getDownPinsSize();
    }

    int getDownPinsSize() {
        return downPins.size();
    }

    List<DownPin> copyDownPins() {
        return new ArrayList<>(downPins);
    }
}
