package bowling.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FinalScore {

    private Roll first;
    private Roll second;

    public FinalScore(Roll first, Roll second) {
        this.first = first;
        this.second = second;
    }

    private BowlingScore toBowlingScore(Roll roll) {
        return roll.isSpare() ? BowlingScore.STRIKE : roll.toBowlingScore();
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
        BowlingScore secondScore = toBowlingScore(second);
        if (isSpared()) {
            secondScore = BowlingScore.SPARE;
        }
        return Arrays.asList(toBowlingScore(first), secondScore).stream()
                .map(BowlingScore::toString)
                .collect(Collectors.joining("|"));
    }
}
