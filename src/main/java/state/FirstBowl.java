package state;

import domain.Score;

public class FirstBowl extends State {
    private static final String GUTTER = "-";
    private static final String PIPE = "|";
    private static final int TEN_PINS = 10;

    private int falledPins;

    public FirstBowl(int throwing) {
        super(false);
        falledPins = throwing;
    }

    public State throwing(int throwing) {
        if (falledPins + throwing == TEN_PINS) {
            return new Spare(falledPins, throwing);
        }
        return new Open(falledPins, throwing);
    }

    @Override
    public Score updateScore(Score beforeScore) {
//        throw new RuntimeException("FirstBowl : 계산할 수 없는 상태입니다.");
        return beforeScore.throwing(falledPins);
    }

    @Override
    public String printState() {
        String falledPins = String.valueOf(this.falledPins);
        if (this.falledPins == 0) {
            falledPins = GUTTER;
        }
        return falledPins;
    }

    @Override
    public Score getScore() {
        throw new RuntimeException("FirstBowl : 현재 상태에서는 점수를 구할 수 없습니다.");
    }

    public static boolean isFirstBowl(State state) {
        return state instanceof FirstBowl;
    }
}
