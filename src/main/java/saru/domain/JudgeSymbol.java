package saru.domain;

import saru.BowlSymbol;

import java.util.List;

public class JudgeSymbol {
    private static final int MAX_DOWN_PIN = 10;
    private static final int FIRST_INDEX = 0;
    private static final int SECOND_INDEX = 1;
    private static final int THIRD_INDEX = 2;
    private static final int LAST_FRAME_INDEX = 3;

    private JudgeSymbol() {
        // empty
    }

    public static BowlSymbol judge(Frame frame, int index) {
        if (frame.getMaxBallCount() == LAST_FRAME_INDEX) {
            return getLastFrameBowlSymbol(frame, index);
        }

        return getNormalFrameBowlSymbol(frame, index);
    }

    private static BowlSymbol getLastFrameBowlSymbol(Frame frame, int index) {
        List<DownPin> downPins = frame.copyDownPins();

        switch (index) {
            case FIRST_INDEX:
                if (downPinFirstTen(downPins)) return BowlSymbol.STRIKE;

                return BowlSymbol.NORMAL;
            case SECOND_INDEX:
                if (downPinFirstTenSecondTen(downPins)) return BowlSymbol.STRIKE;

                if (downPinUntilSecondSumTen(downPins)) return BowlSymbol.SPARE;

                return BowlSymbol.NORMAL;
            case THIRD_INDEX:
                if (downPinSecondTenThirdTen(downPins)) return BowlSymbol.STRIKE;

                if (downPinFirstNotTenUntilSecondSumTenThirdTen(downPins)) return BowlSymbol.STRIKE;

                if (downPinFirstTenSecondNotTenSecondThirdSumTen(downPins)) return BowlSymbol.SPARE;

                return BowlSymbol.NORMAL;
            default:
                throw new RuntimeException("치명적인 예외");
        }
    }

    private static boolean downPinFirstTenSecondNotTenSecondThirdSumTen(List<DownPin> downPins) {
        if (downPins.get(FIRST_INDEX).getDownPinCount() == MAX_DOWN_PIN &&
                downPins.get(SECOND_INDEX).getDownPinCount() != MAX_DOWN_PIN &&
                downPins.get(SECOND_INDEX).addWith(downPins.get(THIRD_INDEX)) == MAX_DOWN_PIN) {
            return true;
        }
        return false;
    }

    private static boolean downPinFirstNotTenUntilSecondSumTenThirdTen(List<DownPin> downPins) {
        if (downPins.get(FIRST_INDEX).getDownPinCount() != MAX_DOWN_PIN &&
                downPins.get(SECOND_INDEX).addWith(downPins.get(FIRST_INDEX)) == MAX_DOWN_PIN &&
                downPins.get(THIRD_INDEX).getDownPinCount() == MAX_DOWN_PIN) {
            return true;
        }
        return false;
    }

    private static boolean downPinSecondTenThirdTen(List<DownPin> downPins) {
        if (downPins.get(SECOND_INDEX).getDownPinCount() == MAX_DOWN_PIN &&
                downPins.get(THIRD_INDEX).getDownPinCount() == MAX_DOWN_PIN) {
            return true;
        }
        return false;
    }

    private static boolean downPinUntilSecondSumTen(List<DownPin> downPins) {
        if (downPins.get(FIRST_INDEX).addWith(downPins.get(SECOND_INDEX)) == MAX_DOWN_PIN) {
            return true;
        }
        return false;
    }

    private static boolean downPinFirstTenSecondTen(List<DownPin> downPins) {
        if (downPins.get(FIRST_INDEX).getDownPinCount() == MAX_DOWN_PIN &&
                downPins.get(SECOND_INDEX).getDownPinCount() == MAX_DOWN_PIN) {
            return true;
        }
        return false;
    }

    private static boolean downPinFirstTen(List<DownPin> downPins) {
        if (downPins.get(FIRST_INDEX).getDownPinCount() == MAX_DOWN_PIN) {
            return true;
        }
        return false;
    }

    private static BowlSymbol getNormalFrameBowlSymbol(Frame frame, int index) {
        List<DownPin> downPins = frame.copyDownPins();
        switch (index) {
            case FIRST_INDEX:
                if (downPins.get(0).getDownPinCount() == 10) {
                    return BowlSymbol.STRIKE;
                }

                return BowlSymbol.NORMAL;
            case SECOND_INDEX:
                if (downPins.get(0).addWith(downPins.get(1)) == 10) {
                    return BowlSymbol.SPARE;
                }

                return BowlSymbol.NORMAL;
            default:
                throw new RuntimeException("치명적인 예외");
        }
    }
}