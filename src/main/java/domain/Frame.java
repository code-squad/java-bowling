package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public abstract class Frame {

    private Score totalScore;
    private List<Score> scores;

    Frame() {
        this.scores = new ArrayList<>();
        this.totalScore = Score.of();
    }

    public abstract boolean isFrameEnd();

    public void trying(int score) {
        if (!isValidScore(score)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        addition(score);
    }

    void addition(int score) {
        this.scores.add(Score.of(score));
        this.totalScore.sum(Score.of(score));
    }

    public boolean isSpare() {
        return totalScore.isTen() && isTrySecond();
    }

    public boolean isTen() {
        return totalScore.isTen();
    }

    public Score getFrameScore() {
        return totalScore;
    }

    public boolean isValidScore(int score) {
        return isValidScoreToTotalScore(score);
    }

    public boolean isValidScoreToTotalScore(int score) {
        return totalScore.isValidAdditionScore(score);
    }

    public boolean isTrySecond() {
        return scores.size() == 2;
    }

    public String toScoreString() {
        return scores.stream().map(Score::toString).collect(Collectors.joining(FRAMEBAR.toString()));
    }

    public String spareString() {
        return scores.get(0).toString() + FRAMEBAR + SPARE;
    }

    @Override
    public String toString() {
        if (isSpare()) return spareString();
        return toScoreString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Frame frame = (Frame) o;
        return Objects.equals(scores, frame.scores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scores);
    }
}
