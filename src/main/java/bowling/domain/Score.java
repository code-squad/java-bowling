package bowling.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Score {

    private Roll first;
    private Roll second;


    public Score() {
    }

    public Score(Roll first) {
        this.first = first;
    }

    public Score(Roll first, Roll second) {
        this.first = first;
        if (isStrike()) throw new IllegalArgumentException();
        this.second = second;
    }

    public BowlingScore toBowlingScore() {
        if (isStrike()) return BowlingScore.STRIKE;
        return isSpared() ? BowlingScore.SPARE : BowlingScore.MISS;
    }

    private boolean isStrike() {
        return first.isSpare();
    }

    public boolean isSpared() {
        return BowlingScore.SPARE.getValue() == Arrays.asList(first, second).stream()
                    .map(Roll::toBowlingScore)
                    .mapToInt(BowlingScore::getValue)
                    .sum();
    }


    @Override
    public String toString() {
        if (first == null) return "";
        if (isStrike()) return BowlingScore.STRIKE.toString();
        BowlingScore secondScore = toBowlingScore();
        if (secondScore == BowlingScore.MISS) {
            secondScore = second.toBowlingScore();
        }
        return Arrays.asList(first.toBowlingScore(), secondScore).stream()
                .map(BowlingScore::toString)
                .collect(Collectors.joining("|"));
    }
}
