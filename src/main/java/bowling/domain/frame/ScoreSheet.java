package bowling.domain.frame;

import bowling.domain.Score.Roll;
import bowling.domain.number.MaxCount;

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
            finalFrame = new FinalFrame(finalFrame.add(roll));
        }
    }

    @Override
    public String toString() {
        String temp = frames == null ? "" : frames.toString();
        temp += finalFrame == null ? "" : finalFrame.toString();
        return temp;
    }

    public MaxCount nextMaxCount() {
        if (!hasEmptyFrame()) throw new IllegalArgumentException();
        return frameNextCount();
    }

    private MaxCount frameNextCount() {
        MaxCount maxCount = frames.nextMaxCount();
        if (maxCount == null && finalFrame!=null) {
            maxCount = finalFrame.nextMaxCount();
        }
        return maxCount;
    }
}
