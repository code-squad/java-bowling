package bowling.domain.frame;

import bowling.domain.number.MaxCount;
import bowling.domain.number.Roll;

public class ScoreSheet {
    private Frames frames;
    private FinalFrame finalFrame;

    public ScoreSheet() {
        frames = new Frames();
        finalFrame = new FinalFrame();
    }

    public boolean hasEmptyFrame() {
        return frames.hasEmptyFrame() || finalFrame.hasEmptyFrame();
    }

    public void add(Roll roll) {
        if (frames.hasEmptyFrame()) {
            frames.add(roll);
            return;
        }
        if (finalFrame.hasEmptyFrame()) {
            finalFrame = finalFrame.add(roll);
        }
    }

    public MaxCount nextMaxCount() {
        if (!hasEmptyFrame()) throw new IllegalArgumentException();
        return frameNextMaxCount();
    }

    private MaxCount frameNextMaxCount() {
        MaxCount maxCount = frames.nextMaxCount();
        if (maxCount == null && finalFrame!=null) {
            maxCount = finalFrame.nextMaxCount();
        }
        return maxCount;
    }

    public int currentFrameIndex() {
        if (frames.hasEmptyFrame()) {
            return frames.firstEmptyFrameIndex();
        }
        return frames.size()+1;
    }

    @Override
    public String toString() {
        String temp = frames == null ? "" : frames.toString();
        temp += finalFrame == null ? "" : finalFrame.toString();
        return temp;
    }
}