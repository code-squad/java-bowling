package domain.frame;

import domain.score.Pin;
import domain.score.Score;

public abstract class Frame {
    final Score score;
    final int frameNo;

    Frame(Score score, int frameNo) {
        if (score == null) {
            throw new IllegalArgumentException();
        }
        this.score = score;
        this.frameNo = frameNo;
    }

    void addSecondResult(Pin pin) {
        this.score.addSecond(pin);
    }

    int getNextFrameNo() {
        return frameNo + 1;
    }

    boolean isStrike() {
        return score.isStrike();
    }

    abstract boolean isFinal();

    abstract Frame nextFrame(Score score);

    @Override
    public String toString() {
        return String.format("%-4s", score.toString());
    }
}
