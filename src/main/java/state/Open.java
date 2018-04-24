package state;

import domain.Pins;
import domain.Score;

public class Open extends State implements Cloneable {
    private static final int MIN_PINS = 0;
    private static final String GUTTER = "-";
    private static final String PIPE = "|";

    private final Pins first;
    private final Pins second;

    public Open(Pins first, Pins second) {
        super(true);
        this.first = first;
        this.second = second;
    }

    @Override
    public String printState() {
        String first = this.first.toString();
        String second = this.second.toString();
        if (this.first.isGutter()) {
            first = GUTTER;
        }
        if (this.second.isGutter()) {
            second = GUTTER;
        }
        return first + PIPE + second;
    }

    public static boolean isOpen(State state) {
        return state instanceof Open;
    }

    @Override
    public Score getScore() {
        return Score.ofOpen(first, second);
    }

    @Override
    public State bowl(Pins falledPins) {
        throw new RuntimeException("Open 프레임에서는 더이상 투구할 수 없습니다.");
    }

    @Override
    public State clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Score updateScore(Score beforeScore) {
        beforeScore.bowl(first);
        if (beforeScore.canCalculateScore()) {  // left == 0
            return beforeScore;
        }
        return beforeScore.bowl(second);
    }
}
