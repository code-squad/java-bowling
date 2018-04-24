package state;

import domain.Pins;
import domain.Score;

public class Spare extends State {
    private static final String PIPE = "|";
    private static final String SPARE = "/";
    private static final String GUTTER = "-";

    private final Pins first;
    private final Pins second;

    public Spare(Pins first, Pins second) {
        super(true);
        this.first = first;
        this.second = second;
    }

    @Override
    public String printState() {
        String first = this.first.toString();
        if (this.first.isGutter()) {
            first = GUTTER;
        }
        return first + PIPE + SPARE;
    }

    public static boolean isSpare(State state) {
        return state instanceof Spare;
    }

    @Override
    public State bowl(Pins falledPins) {
        throw new RuntimeException("Spare.java : 해당 상태에서는 투구할 수 없습니다.");
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
        beforeScore.bowl(first);
        if (!beforeScore.canCalculateScore()) {
            return beforeScore.bowl(second);
        }
        return beforeScore;
    }
}
