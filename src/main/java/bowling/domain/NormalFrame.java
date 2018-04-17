package bowling.domain;

public class NormalFrame implements Frame {
    private final Frame nextFrame;
    private final Bowl first;
    private final Bowl second;

    public NormalFrame(int frameNumber) {
        this.first = new Bowl();
        this.second = new Bowl();
        if (frameNumber == 8) {
            this.nextFrame = new LastFrame(frameNumber + 1);
        } else {
            this.nextFrame = new NormalFrame(frameNumber + 1);
        }
    }

    public boolean firstIsPlayed() {
        return first.isPlayed();
    }

    public boolean secondIsPlayed() {
        return second.isPlayed();
    }

    public Integer throwBall(int pinsKnocked) {
        if (firstIsPlayed() && secondIsPlayed()) {
            return nextFrame.throwBall(pinsKnocked);
        }
        return updateBowls(pinsKnocked);
    }

    public Integer updateBowls(int pinsKnocked) {
        if (!firstIsPlayed()) {
            return first.updateBowl(pinsKnocked);
        }
        return second.updateBowl(pinsKnocked);
    }
}