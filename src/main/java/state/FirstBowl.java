package state;

import domain.Pins;
import domain.Score;

public class FirstBowl extends State {
    private static final String GUTTER = "-";
    private static final int NO_LEFT = 0;

    private Pins falledPins;

    public FirstBowl(Pins falledPins) {
        super(false);
        this.falledPins = falledPins;
    }

    @Override
    public State bowl(Pins falledPins) {
        if (this.falledPins.isSpare(falledPins)) {
            return new Spare(this.falledPins, falledPins);
        }
        return new Open(this.falledPins, falledPins);
    }

    @Override
    public Score updateScore(Score beforeScore) {
        return beforeScore.bowl(falledPins);
    }

    @Override
    public String printState() {
        String falledPins = String.valueOf(this.falledPins);
        if (this.falledPins.isGutter()) {
            falledPins = GUTTER;
        }
        return falledPins;
    }

    @Override
    public Score getScore() {
        return falledPins.createFirstBowlScore(NO_LEFT);
    }

    public static boolean isFirstBowl(State state) {
        return state instanceof FirstBowl;
    }
}
