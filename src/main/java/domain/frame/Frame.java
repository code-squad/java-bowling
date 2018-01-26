package domain.frame;

import domain.score.FrameScore;
import domain.score.Pin;

import java.util.Optional;

public abstract class Frame {
    private final FrameScore frameScore;

    Frame(FrameScore frameScore) {
        if (frameScore == null) {
            throw new IllegalArgumentException();
        }
        this.frameScore = frameScore;
    }

    void addResult(Pin pin) {
        this.frameScore.bowl(pin);
    }

    boolean isFinish() {
        return frameScore.isFinish();
    }

    boolean isStrike() {
        return frameScore.isStrike();
    }

    Optional<Integer> calculateFrameScore() {
        return frameScore.getFrameScore();
    }

    Integer getFirstScore() {
        return frameScore.getFirstScore();
    }

    Optional<Integer> getSumOfScore() {
        return frameScore.getSumOfFirstAndSecondScore();
    }

    abstract Optional<Integer> calculateAdditionalScore(Frame... f);

    @Override
    public String toString() {
        return String.format("%-4s", frameScore.toString());
    }
}
