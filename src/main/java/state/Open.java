package state;

import domain.Score;

public class Open extends State implements Cloneable {
    private static final int NO_PINS = 0;
    private static final String GUTTER = "-";
    private static final String PIPE = "|";

    private final int first;
    private final int second;

    public Open(int first, int second) {
        super(true);
        this.first = first;
        this.second = second;
    }

    @Override
    public String printState() {
        String first = String.valueOf(this.first);
        String second = String.valueOf(this.second);
        if (this.first == NO_PINS) {
            first = GUTTER;
        }
        if (this.second == NO_PINS) {
            second = GUTTER;
        }
        return first + PIPE + second;
    }

    @Override
    public State throwing(int throwing) {
        throw new RuntimeException("Open 프레임에서는 더이상 투구할 수 없습니다.");
    }

    public static boolean isOpen(State state) {
        return state instanceof Open;
    }

    @Override
    public Score getScore() {
        return Score.ofOpen(first, second);
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Score updateScore(Score beforeScore) {
        beforeScore.throwing(first);
        if (beforeScore.canCalculateScore()) {  // left == 0
            return beforeScore;
        }
        return beforeScore.throwing(second);
    }
}
