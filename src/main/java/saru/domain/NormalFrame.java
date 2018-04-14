package saru.domain;

public class NormalFrame extends Frame {
    private static final int MAX_BALL_COUNT = 2;

    private NormalFrame(int maxBallCount) {
        super(maxBallCount);
    }

    public static NormalFrame of() {
        return new NormalFrame(MAX_BALL_COUNT);
    }

    @Override
    boolean checkThrowingPossible() {
        if (getDownPinsSize() == 0) {
            return true;
        }

        if (checkStrike() || checkFull()) {
            return false;
        }

        return true;
    }

    private boolean checkStrike() {
        return downPins.get(FIRST_INDEX).equals(DownPin.of(MAX_DOWN_PIN));
    }
}
