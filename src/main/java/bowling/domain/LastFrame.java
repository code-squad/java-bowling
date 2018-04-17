package bowling.domain;

public class LastFrame implements Frame {
    private final int frameNumber;

    public LastFrame(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    @Override
    public Integer throwBall(int pinsKnocked) {
        return null;
    }
}
