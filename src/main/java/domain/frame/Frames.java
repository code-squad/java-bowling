package domain.frame;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private static final int LIMIT_NUM = 10;
    private List<Frame> frames;
    private int nextFrameIdx;

    public Frames() {
        frames = new ArrayList<>();
        nextFrameIdx = 0;
    }

    public void recordScore(int score) {
        Frame currentFrame = getCurrentFrame();
        currentFrame.addScore(score);
        if (currentFrame.isFinish()) {
            nextFrameIdx++;
        }
    }

    private Frame getCurrentFrame() {
        try {
            return frames.get(nextFrameIdx);
        } catch (IndexOutOfBoundsException e) {
            frames.add(createFrame());
            return frames.get(nextFrameIdx);
        }
    }

    // 나중에 역할 분리 가능성 있음 - 새로운 프레임 생성하기(프레임이 2종류), 공통적이잖아 그러면 넘버를 줘야 마지막인지 파악하는거 아니야?
    // 1~9 프레임, 10프레임 나눠야할 것 같음
    private static Frame createFrame() {
        return new Frame();
    }

    public int getCurrentFrameNum() {
        return nextFrameIdx + 1;
    }


    public boolean isFinish() {
        return frames.size() == LIMIT_NUM && frames.stream().allMatch(Frame::isFinish);
    }

    public static boolean isLastFrame(int frameNum) {
        return frameNum == LIMIT_NUM;
    }
}
