package saru.domain;

public class NormalFrame extends Frame {
    private static final int MAX_BALL_COUNT = 2;
    private static final int MAX_DOWN_PIN = 10;

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
        return getFirstElementDownPins().equals(DownPin.of(MAX_DOWN_PIN));
    }
}
