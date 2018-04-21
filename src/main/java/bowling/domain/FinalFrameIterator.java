package bowling.domain;

import java.util.Iterator;

public class FinalFrameIterator implements Iterator {

    private FinalFrame finalFrame;
    private int tryNumber;

    public FinalFrameIterator(FinalFrame finalFrame) {
        this.finalFrame = finalFrame;
        this.tryNumber = 0;
    }

    @Override
    public boolean hasNext() {
        if (tryNumber >= BowlingRule.MAX_FINAL_SIZE) {
            return false;
        }

        return true;
    }

    @Override
    public FinalFrame next() {
        tryNumber++;
        return finalFrame;
    }
}
