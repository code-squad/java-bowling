package bowling.domain;

public class NormalFrame implements Frame {
    private final Frame nextFrame;
    private final FirstBowl first = new FirstBowl();

    public NormalFrame(int frameNumber) {
        if (frameNumber == 8) {
            this.nextFrame = new LastFrame(frameNumber + 1);
        } else {
            this.nextFrame = new NormalFrame(frameNumber + 1);
        }
    }

    public boolean firstIsPlayed() {
        return first.firstIsPlayed();
    }

    public boolean secondIsPlayed() {
        return first.secondIsPlayed();
    }

    public Integer throwBall(int pinsKnocked) {
        if (firstIsPlayed() && secondIsPlayed()) {
            return nextFrame.throwBall(pinsKnocked);
        }
        return updateBowls(pinsKnocked);
    }

    public Integer updateBowls(int pinsKnocked) {
        return first.updateBowl(pinsKnocked);
    }

    public boolean isStrike() {
        return first.isStrike();
    }

    public boolean isSpare() {
        return first.isSpare();
    }
}