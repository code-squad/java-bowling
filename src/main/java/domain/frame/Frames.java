package domain.frame;

import utils.FrameFactory;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    public static final int LIMIT_NUM = 10;
    private List<Frame> frames;

    private int currentFrameIdx;

    public Frames() {
        frames = new ArrayList<>();
        currentFrameIdx = 0;
    }

    public String recordPins(int num) {
        Frame currentFrame = getCurrentFrame();
        String convertedPinNum = currentFrame.recordPins(num);

        if (currentFrame.isFinish()) {
            currentFrameIdx++;
        }

        return convertedPinNum;
    }

    public Frame getCurrentFrame() {
        try {
            return frames.get(currentFrameIdx);
        } catch (IndexOutOfBoundsException e) {
            int frameNum = getCurrentFrameNum();
            frames.add(FrameFactory.of(frameNum));
            return frames.get(currentFrameIdx);
        }
    }

    public int getCurrentFrameIdx() {
        return currentFrameIdx;
    }

    public int getCurrentFrameNum() {
        return currentFrameIdx + 1;
    }

    public boolean isFinish() {
        return frames.size() == LIMIT_NUM && frames.stream().allMatch(Frame::isFinish);
    }

    public static boolean isLast(int frameNum) {
        return frameNum == LIMIT_NUM;
    }
}
