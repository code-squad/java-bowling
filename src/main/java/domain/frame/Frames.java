package domain.frame;

import domain.frame.result.FrameResults;
import utils.FrameFactory;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    public static final int LIMIT_NUM = 10;
    private List<Frame> frames = new ArrayList<>();
    private int currentFrameIdx = 0;

    public void recordPins(FrameResults results, int num) {
        Frame currentFrame = getCurrentFrame();
        List<Frame> recordableFrames = getRecordableFrames(currentFrameIdx);
        for (Frame frame : recordableFrames) {
            results.addMessage(frame, frame.recordPins(num));
            results.addScore(frame, frame.getScore());
        }

        if (isPossibleNextIdx(currentFrame)) {
            currentFrameIdx++;
        }
    }

    private Frame getCurrentFrame() {
        try {
            return frames.get(currentFrameIdx);
        } catch (IndexOutOfBoundsException e) {
            frames.add(FrameFactory.of(getCurrentFrameNum()));
            return frames.get(currentFrameIdx);
        }
    }

    private List<Frame> getRecordableFrames(int boundary) {
        List<Frame> recordableFrames = new ArrayList<>();
        for (int i = 0; i <= boundary; i++) {
            Frame frame = frames.get(i);
            if (!frame.isRegularRecordFinish() || (frame.isRegularRecordFinish() && !frame.isFinish())) {
                recordableFrames.add(frame);
            }
        }
        return recordableFrames;
    }

    private boolean isPossibleNextIdx(Frame currentFrame) {
        return currentFrame.isRegularRecordFinish() && frames.size() < LIMIT_NUM;
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


    public Frame getFrame(int frameNum) throws IndexOutOfBoundsException {
        int frameIdx = frameNum - 1;
        return frames.get(frameIdx);
    }
}
