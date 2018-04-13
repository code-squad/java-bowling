package domain.frame;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    public static final int LIMIT = 10;
    private List<Frame> frames = new ArrayList<>();
    private Frame currentFrame;

    public Frames() {
        currentFrame = Frame.of(1);
    }

    public void roll(int num) throws IllegalArgumentException {
        if (!frames.contains(currentFrame)) {
            frames.add(currentFrame);
        }

        Frame frame = currentFrame.roll(num);
        if (currentFrame.isDiffFrame(frame)) {
            currentFrame = frame;
        }
    }

    public static boolean isLimit(int frameNum) {
        return frameNum == LIMIT;
    }

    public boolean isFinish() {
        return currentFrame.isLast() && currentFrame.isFinish();
    }

    public int getFrameNum() {
        return currentFrame.getFrameNum();
    }
}
