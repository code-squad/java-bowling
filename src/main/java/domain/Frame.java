package domain;

import java.util.Objects;

import static domain.Figure.FRAMEBAR;
import static domain.Figure.SPARE;

public abstract class Frame {

    Scores scores;

    public abstract boolean isFrameEnd();

    public void trying(int score) {
        if (!isValidScore(score)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        this.scores.add(score);
    }

    public abstract boolean isValidScore(int score);

    public boolean isSpare() {
        return scores.isTen() && scores.isTrySecond();
    }

    public Score getFrameScore() {
        return scores.getTotalScore();
    }

    @Override
    public String toString() {
        if (isSpare()) return scores.firstString() + FRAMEBAR + SPARE;
        return scores.toString();
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
