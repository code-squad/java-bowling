package domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private List<Frame> frames;
    private Frame currentFrame;

    public Frames() {
        this.frames = new ArrayList<>();
    }

    public void recordScore(int score) {
        if (currentFrame == null || currentFrame.isFinish()) {
            setCurrentFrame();
        }
        currentFrame.addScore(score);
    }

    private void setCurrentFrame() {
        Frame frame = createFrame();
        frames.add(frame);
        currentFrame = frame;
    }

    // 새로운 프레임 생성하기 : 나중에 역할 분리 가능성 있음(프레임이 2종류기때문에)
    private Frame createFrame() {
        return new Frame();
    }

    public int getCurrentFrameNumber() {
        return frames.size();
    }
}
