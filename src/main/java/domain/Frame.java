package domain;

import java.util.Objects;

public class Frame {

    Scores scores;

    public Frame() {
        scores = new Scores();
    }

    public void trying(int score) {
        scores.add(score);
    }

    public boolean isFrameEnd() {
        return scores.isTen() || scores.isTrySecond();
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

    @Override
    public String toString() {
        if (isSpare()) return scores.firstString() + "|/";
        if (isStrike()) return "X  ";
        return scores.toString();
    }

}
