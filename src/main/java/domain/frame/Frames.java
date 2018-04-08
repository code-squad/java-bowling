package domain.frame;

import utils.FrameFactory;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    public static final int LIMIT_NUM = 10;
    private List<Frame> frames;
    private int nextFrameIdx;

    public Frames() {
        frames = new ArrayList<>();
        nextFrameIdx = 0;
    }

    public String recordScore(int score) {
        Frame currentFrame = getCurrentFrame();
        String convertedScore = currentFrame.addScore(score);
        if (currentFrame.isFinish()) {
            nextFrameIdx++;
        }
        return convertedScore;
    }

    public Frame getCurrentFrame() {
        try {
            return frames.get(nextFrameIdx);
        } catch (IndexOutOfBoundsException e) {
            int frameNum = nextFrameIdx + 1;
            frames.add(FrameFactory.of(frameNum));
            return frames.get(nextFrameIdx);
        }
    }

    public int getCurrentFrameNum() {
        return nextFrameIdx + 1;
    }

    public boolean isFinish() {
        return frames.size() == LIMIT_NUM && frames.stream().allMatch(Frame::isFinish);
    }

    public static boolean isLast(int frameNum) {
        return frameNum == LIMIT_NUM;
    }
}
