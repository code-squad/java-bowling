package bowling.domain;

public class LabelFrame {
    private int frameNumber;

    public LabelFrame(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    @Override
    public String toString() {
        return Formatter.formatLabel(frameNumber);
    }
}