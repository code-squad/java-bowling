package domain.frame;

import domain.frame.result.FrameResults;
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

    public void recordPins(FrameResults results, int num) {
        List<Frame> recordableFrames = getRecordableFrame(getCurrentFrameNum());
        for (Frame frame : recordableFrames) {
            results.addMessage(frame, frame.recordPins(num));
            results.addScore(frame, frame.getScore());
        }

        Frame currentFrame = getCurrentFrame();
        if (currentFrame.isFinish()) {
            currentFrameIdx++;
        }
    }

    private List<Frame> getRecordableFrame(int currentFrameNum) {
        List<Frame> frames = new ArrayList<>();
        for (int idx = 0; idx < currentFrameNum - 1; idx++) {
            Frame frame = frames.get(idx);
            if (!frame.isFinish()) {
                frames.add(frame);
            }
        }
        return frames;
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
