package bowling.domain;

import java.util.Iterator;

public class NormalFrameIterator implements Iterator {

    private NormalFrame normalFrame;
    private int tryNumber;

    public NormalFrameIterator(NormalFrame normalFrame) {
        this.normalFrame = normalFrame;
        this.tryNumber = 0;
    }

    @Override
    public boolean hasNext() {
        if (tryNumber >= BowlingRule.MAX_NORMAL_SIZE ||
                normalFrame.frameStatus.equals(FrameStatus.STRIKE)) {
            return false;
        }

        return true;
    }

    @Override
    public NormalFrame next() {
        tryNumber++;
        return normalFrame;
    }
}
