package bowling;

import bowling.status.Ready;
import bowling.status.Status;

/**
 * @author sangsik.kim
 */
public class NormalFrame implements Frame {
    private int frameNumber;
    private Status status = new Ready();

    public NormalFrame() {
        this(1);
    }

    public NormalFrame(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    @Override
    public String status() {
        return this.status.getClass().getSimpleName();
    }

    @Override
    public Score getScore() {
        return new Score(this.frameNumber, this.status.getScore());
    }

    @Override
    public Frame bowl(int pin) {
        this.status = this.status.bowl(pin);
        return this;
    }

    @Override
    public boolean isFinish() {
        return this.status.isFinish();
    }
}
