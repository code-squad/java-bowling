package saru.domain;

import java.util.*;

public abstract class Frame {
    private static final int MAX_DOWN_PIN = 10;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private List<DownPin> downPins = new ArrayList<>();

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
        if (downPin.addWith(downPins.get(FIRST_INDEX)) > MAX_DOWN_PIN) {
            throw new IllegalArgumentException("downPin 갯수 합이 10이 넘음");
        }
    }

    // TODO downPins 이나 pin 리턴할때 new로 새로 생성 후 리턴?

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

    DownPin getFirstElementDownPins() {
        return downPins.get(FIRST_INDEX);
    }

    DownPin getSecondElementDownPins() {
        return downPins.get(SECOND_INDEX);
    }

    boolean addDownPin(DownPin downPin) {
        downPins.add(downPin);

        return !checkFull();
    }

    List<DownPin> copyDownPins() {
        return new ArrayList<>(downPins);
    }

    int getMaxBallCount() {
        return maxBallCount;
    }
}
