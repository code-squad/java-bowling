package domain;

import java.util.Objects;

public abstract class Frame {

    Scores scores;

    public abstract boolean isFrameEnd();

    public void trying(int score) {
        this.scores.add(score);
    }

    public boolean isStrike() {
        return scores.isTen() && scores.isTryFirst();
    }

    public boolean isSpare() {
        return scores.isTen() && scores.isTrySecond();
    }

    public Score getFrameScore() {
        return scores.getTotalScore();
    }

    @Override
    public String toString() {
        if (isSpare()) return scores.firstString() + "|"+Figure.SPARE;
        if (isStrike()) return Figure.STRIKE.toString();
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
