package state;

import domain.Pins;
import domain.Score;

public class Ready extends State {
    private static final String EMPTY = "";

    public Ready() {
        super(false);
    }

    @Override
    public State bowl(Pins falledPins) {
        if (falledPins.isStrike()) {
            return new Strike();
        }
        return new FirstBowl(falledPins);
    }

    @Override
    public Score updateScore(Score beforeScore) {
        throw new RuntimeException("Ready : 계산할 수 없는 상태입니다.");
    }

    @Override
    public String printState() {
        return EMPTY;
    }

    @Override
    public Score getScore() {
        throw new RuntimeException("Ready : 현재 상태에서는 점수를 구할 수 없습니다.");
    }

    public static boolean isReady(State state) {
        return state instanceof Ready;
    }
}
