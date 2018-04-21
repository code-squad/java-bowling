package state;

import domain.Score;

public class Spare extends State {
    private static final String PIPE = "|";
    private static final String SPARE = "/";
    private static final String GUTTER = "-";
    private static final int TEN_PINS = 10;
    private static final int NO_PINS = 0;

    private final int first;
    private final int second;

    public Spare(int first, int second) {
        super(true);
        this.first = first;
        this.second = second;
    }

    @Override
    public String printState() {
        String first = String.valueOf(this.first);
        if (this.first == NO_PINS) {
            first = GUTTER;
        }
        return first + PIPE + SPARE;
    }

    public State throwing(int throwing) {
        if (throwing == TEN_PINS) {
            return new Strike();
        }
        return new FirstBowl(throwing);
    }

    public static boolean isSpare(State state) {
        return state instanceof Spare;
    }

    @Override
    public Score getScore() {
        return Score.ofSpare();
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Score updateScore(Score beforeScore) {
        beforeScore.throwing(first);
        if (!beforeScore.canCalculateScore()) {
            return beforeScore.throwing(second);
        }
        return beforeScore;
    }
}
