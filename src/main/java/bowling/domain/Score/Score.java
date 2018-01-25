package bowling.domain.Score;

import bowling.domain.number.BowlingScore;
import bowling.domain.number.MaxCount;
import bowling.domain.number.Roll;
import bowling.util.ScoreAssistance;

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

    public Score (Roll first, Roll second) {
        this.first = first;
        this. second = second;
    }

    public BowlingScore toBowlingScore() {
        if (isStrike()) return BowlingScore.STRIKE;
        return isSpared() ? BowlingScore.SPARE : BowlingScore.MISS;
    }

    private boolean isStrike() {
        return first.isSpare();
    }

    public boolean isSpared() {
        return BowlingScore.SPARE.getValue() == scoreSum();
    }

    public boolean isEmpty() {
        if (first == null) return true;
        if (isStrike()) return false;
        return second == null;
    }

    public boolean isOverMaxCount() {
        return first.isSpare() ? true : ScoreAssistance.isOverMaxPinCount(scoreSum());
    }

    private int scoreSum() {
        return Arrays.asList(first, second).stream()
                .map(Roll::toBowlingScore)
                .mapToInt(BowlingScore::getValue)
                .sum();
    }

    public Score add(Roll roll) {
        if (!isEmpty()) throw new IllegalArgumentException();
        if (first == null) {
            first = roll;
            return new Score(first);
        }
        second = roll;
        if (isOverMaxCount()) throw new IllegalArgumentException();
        return new Score(first, second);
    }

    public MaxCount calcMaxDownCount() {
        if (first == null) return new MaxCount(ScoreAssistance.MAX_PIN_COUNT);
        return new MaxCount(ScoreAssistance.MAX_PIN_COUNT - first.toBowlingScore().getValue());
    }

    @Override
    public String toString() {
        if (first == null) return "";
        if (isStrike()) return BowlingScore.STRIKE.getString();
        if (second == null) return first.toBowlingScore().getString();
        BowlingScore secondScore = toBowlingScore();
        if (secondScore == BowlingScore.MISS) {
            secondScore = second.toBowlingScore();
        }
        return Arrays.asList(first.toBowlingScore(), secondScore).stream()
                .map(BowlingScore::getString)
                .collect(Collectors.joining("|"));
    }
}