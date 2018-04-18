package saru.domain;

import saru.BowlSymbol;

import java.util.ArrayList;
import java.util.List;

public class LastFrame extends Frame {
    private static final int MAX_BALL_COUNT = 3;
    private static final int FIRST_THROW = 1;
    private static final int SECOND_THROW = 2;
    private static final int MAX_DOWN_PIN = 10;

    private LastFrame(int maxBallCount) {
        super(maxBallCount);
    }

    public static LastFrame of() {
        return new LastFrame(MAX_BALL_COUNT);
    }

    @Override
    void throwing(DownPin downPin) {
        if (!checkThrowingPossible()) {
            return;
        }

        checkExceptionProc(downPin);

        addDownPin(downPin);
    }

    private void checkExceptionProc(DownPin downPin) {
        // 첫 투구가 있었지만 스트라이크가 아니고
        // 두번째 투구수까지의 합이 10이 넘음
        if (getDownPinsSize() == FIRST_THROW) {
            checkUntilSecondThrowingIsOverTen(downPin);
        }

        // 이미 두번의 투구가 있었고 두번째 투구가 스트라이크가 아니고
        // 두번째와 세번째 투구의 합이 10이 넘음
        // TODO 조건이 잘못 되었나?? 너무 꼬인 느낌
        if (getDownPinsSize() == SECOND_THROW) {
            checkThirdThrowException(downPin);
        }
    }

    private void checkThirdThrowException(DownPin downPin) {
        if (checkFirstThrowIsStrike() &&
                checkSecondThrowingIsNotStrike() &&
                getSecondElementDownPins().addWith(downPin) > MAX_DOWN_PIN) {
            throw new IllegalArgumentException("두번째 세번째의 합이 10이 넘음");

        }
    }

    private boolean checkFirstThrowIsStrike() {
        return getFirstElementDownPins().getDownPinCount() == MAX_DOWN_PIN;
    }

    private boolean checkFirstThrowingIsNotStrike() {
        return !getFirstElementDownPins().checkStrike();
    }

    private void checkUntilSecondThrowingIsOverTen(DownPin downPin) {
        if (checkFirstThrowingIsNotStrike() &&
                downPin.addWith(getFirstElementDownPins()) > MAX_DOWN_PIN) {
            throw new IllegalArgumentException("두번째 투구수까지의 합이 10이 넘음");
        }
    }

    private boolean checkSecondThrowingIsNotStrike() {
        return !getSecondElementDownPins().checkStrike();
    }

    @Override
    boolean checkThrowingPossible() {
        if (getDownPinsSize() == 0) {
            return true;
        }

        // 투구수가 2 이상이고 두번째까지의 합이 10미만이면 || checkFull
        if (((getDownPinsSize() >= SECOND_THROW) &&
                checkSumUntilTwoIsUnderTen()) || checkFull()) {
            return false;
        }

        return true;
    }

    private boolean checkSumUntilTwoIsUnderTen() {
        return getFirstElementDownPins().addWith(getSecondElementDownPins()) < MAX_DOWN_PIN;
    }

    @Override
    public String toString() {
        List<DownPin> downPins = copyDownPins();
        List<String> strList = new ArrayList<>();

        for (int i = 0; i < downPins.size(); i++) {
            BowlSymbol bowlSymbol = JudgeSymbol.judge(this, i);

            if (bowlSymbol != BowlSymbol.NORMAL) {
                strList.add(bowlSymbol.getSymbol());
                continue;
            }

            strList.add(downPins.get(i).toString());
        }

        return String.join("|", strList);
    }
}
