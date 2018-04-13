package bowling.domain.frame;

import static bowling.domain.Utils.Formatter.formatLabel;

public class LabelFrame {
    private final int frameNumber;

    public LabelFrame(int frameNumber) {
        this.frameNumber = frameNumber;
    }

    @Override
    public String toString() {
        return "  " + formatLabel(frameNumber);
    }
}