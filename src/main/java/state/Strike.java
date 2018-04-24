package state;

import domain.Pins;
import domain.Score;

public class Strike extends State implements Cloneable {
    private static final String STRIKE = "X";
    private static final int MAX_PINS = 10;

    public Strike() {
        super(true);
    }

    @Override
    public String printState() {
        return STRIKE;
    }

    @Override
    public State bowl(Pins falledPins) {
        if (falledPins.isStrike()) {
            return new Strike();
        }
        return new FirstBowl(falledPins);
    }

    public static boolean isStrike(State state) {
        return state instanceof Strike;
    }

    @Override
    public Score getScore() {
        return Score.ofStrike();
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Score updateScore(Score beforeScore) {
        return beforeScore.bowl(new Pins(MAX_PINS));
    }
}
