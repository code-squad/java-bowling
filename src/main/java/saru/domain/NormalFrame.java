package saru.domain;

import saru.BowlSymbol;

import java.util.ArrayList;
import java.util.List;

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
