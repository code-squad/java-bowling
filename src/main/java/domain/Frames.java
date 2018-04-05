package domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private static final int LIMIT_NUM = 10;
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

    // 나중에 역할 분리 가능성 있음 - 새로운 프레임 생성하기(프레임이 2종류)
    private Frame createFrame() {
        return new Frame();
    }

    public int getTurnNumber() {
        //currentFrame에 프레임 넘버를 줘야해? 흠...굳이? 무조건 출력이 먼저라서.... 몇번쨰 프레임인지 알 정보가 있어야
        return frames.size() + 1;
    }

    public boolean isFinish() {
        return frames.size() == LIMIT_NUM && frames.stream().allMatch(Frame::isFinish);
    }
}
