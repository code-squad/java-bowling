package saru.domain;

public class LastFrame extends Frame {
    private static final int MAX_BALL_COUNT = 3;
    private static final int SECOND_THROW = 2;

    private LastFrame(int maxBallCount) {
        super(maxBallCount);
    }

    public static LastFrame of() {
        return new LastFrame(MAX_BALL_COUNT);
    }

    @Override
    void throwing(DownPin downPin) {
        // 빈 상태가 아니고, 첫투구가 스트라이크가 아니고
        if (!downPins.isEmpty() && checkFirstThrowingIsNotStrike()) {
            checkUntilSecondThrowingIsOverTen(downPin);
        }

        downPins.add(downPin);
    }

    private void checkUntilSecondThrowingIsOverTen(DownPin downPin) {
        if (downPin.addWith(downPins.get(FIRST_INDEX)) > MAX_DOWN_PIN) {
            throw new IllegalArgumentException("두번째 투구수까지의 합이 10이 넘음");
        }
    }

    private boolean checkFirstThrowingIsNotStrike() {
        return !downPins.get(FIRST_INDEX).equals(DownPin.of(MAX_DOWN_PIN));
    }

    @Override
    boolean checkThrowingPossible() {
        if (getDownPinsSize() == 0) {
            return true;
        }

        // 투구수가 2 이상이고 두번째까지의 합이 10미만이면 || checkFull
        if ((downPins.size() >= SECOND_THROW && checkSumUntilTwoIsUnderTen()) || checkFull()) {
            return false;
        }

        return true;
    }

    private boolean checkSumUntilTwoIsUnderTen() {
        return downPins.get(FIRST_INDEX).addWith(downPins.get(SECOND_INDEX)) < MAX_DOWN_PIN;
    }
}
