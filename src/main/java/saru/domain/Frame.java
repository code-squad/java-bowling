package saru.domain;

import sun.jvm.hotspot.debugger.InputLexer;

import java.util.*;

public abstract class Frame {
    static final int MAX_DOWN_PIN = 10;
    static final int FIRST_INDEX = 0;
    static final int SECOND_INDEX = 1;
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
            throwingProc(downPin);
        }

        downPins.add(downPin);
    }

    private void throwingProc(DownPin downPin) {
        try {
            checkValidThrowing(downPin);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }

    private void checkValidThrowing(DownPin downPin) {
        if (downPin.addWith(downPins.get(0)) > MAX_DOWN_PIN) {
            throw new IllegalArgumentException("downPin 갯수 합이 10이 넘음");
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

    public List<DownPin> copyDownPins() {
        return new ArrayList<>(downPins);
    }
}
