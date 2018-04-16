package saru.domain;

import saru.BowlSymbol;

import java.util.List;

public class JudgeSymbol {
    private JudgeSymbol() {
        // empty
    }

    public static BowlSymbol judge(List<DownPin> downPins) {
        // TODO 일단 라스트프레임 먼저
        switch (downPins.size()) {
            case 1:
                if (downPins.get(0).getDownPinCount() == 10) {
                    return BowlSymbol.STRIKE;
                }

                return BowlSymbol.NORMAL;
            case 2:
                if (downPins.get(0).getDownPinCount() == 10 &&
                        downPins.get(1).getDownPinCount() == 10) {
                    return BowlSymbol.STRIKE;
                }

                if (downPins.get(0).addWith(downPins.get(1)) == 10) {
                    return BowlSymbol.SPARE;
                }

                return BowlSymbol.NORMAL;
            case 3:
                if (downPins.get(1).getDownPinCount() == 10 &&
                        downPins.get(2).getDownPinCount() == 10) {
                    return BowlSymbol.STRIKE;
                }

                if (downPins.get(0).getDownPinCount() != 10 &&
                        downPins.get(1).addWith(downPins.get(0)) == 10 &&
                        downPins.get(2).getDownPinCount() == 10) {
                    return BowlSymbol.STRIKE;
                }

                if (downPins.get(0).getDownPinCount() == 10 &&
                        downPins.get(1).getDownPinCount() != 10 &&
                        downPins.get(1).addWith(downPins.get(2)) == 10) {
                    return BowlSymbol.SPARE;
                }

                return BowlSymbol.NORMAL;
            default:
                throw new RuntimeException("치명적인 예외");
        }
    }
}
