package domain;

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
}
