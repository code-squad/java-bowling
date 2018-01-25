package bowling.domain.Score;

import bowling.domain.number.BowlingScore;
import bowling.domain.number.MaxCount;
import bowling.util.ScoreAssistance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FinalScore {

    private Roll first;
    private Roll second;

    public FinalScore() {
    }

    public FinalScore(Roll first) {
        this.first = first;
    }

    public FinalScore(FinalScore score) {
        this.first = score.first;
        this.second = score.second;
    }

    private BowlingScore toBowlingScore(Roll roll) {
        return roll.isSpare() ? BowlingScore.STRIKE : roll.toBowlingScore();
    }

    public boolean isSpared() {
        List<Roll> score = new ArrayList<>();
        score.add(second);
        if (!first.isSpare()) {
            score.add(first);
        }
        return BowlingScore.SPARE.getValue() == score.stream()
                .map(Roll::toBowlingScore)
                .mapToInt(BowlingScore::getValue)
                .sum();
    }

    public boolean isEmpty() {
        if (first == null || second == null) return true;
        return false;
    }

    public FinalScore add(Roll roll) {
        if (first == null) {
            first = roll;
            return this;
        }
        second = roll;
        return  this;
    }

    public MaxCount calcNextMaxCount() {
        if (!isEmpty()) return null;
        if (first == null) return new MaxCount(ScoreAssistance.MAX_PIN_COUNT);
        return first.isSpare() ? new MaxCount(ScoreAssistance.MAX_PIN_COUNT) : new MaxCount(ScoreAssistance.MAX_PIN_COUNT - first.toBowlingScore().getValue());
    }

    @Override
    public String toString() {
        if (first == null) return "";
        if (second == null) return toBowlingScore(first).toString();
        BowlingScore secondScore = isSpared() ? BowlingScore.SPARE : second.toBowlingScore();
        if (first.isSpare() && second.isSpare()) {
            secondScore = BowlingScore.STRIKE;
        }
        return Arrays.asList(toBowlingScore(first), secondScore).stream()
                .map(BowlingScore::toString)
                .collect(Collectors.joining("|"));
    }
}