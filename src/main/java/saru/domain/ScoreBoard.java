package saru.domain;

import java.util.*;

public class ScoreBoard {
    private static final int MAX_DOWN_PIN = 10;
    private static final int MAX_NORMAL_FRAME = 9;
    private int nowFrameIndex = 0;
    private User user;

    private List<Frame> frames = new ArrayList<>(MAX_DOWN_PIN);

    private ScoreBoard(User user) {
        init();
    }

    private void init() {
        for (int i = 0; i < MAX_NORMAL_FRAME; i++) {
            frames.add(NormalFrame.of());
        }

        frames.add(LastFrame.of());
    }

    public static ScoreBoard of(User user) {
        return new ScoreBoard(user);
    }

    int getFrameSize() {
        return frames.size();
    }

    public int throwing(DownPin downPin) {
        Frame frame = frames.get(nowFrameIndex);
        frame.throwing(downPin);

        nextFrame();

        // TODO return downPinsSize
        return frame.getDownPinsSize();
    }

    public int getNowFrameIndex() {
        return nowFrameIndex;
    }

    public List<Frame> getFrames() {
        return frames;
    }

    private void nextFrame() {
        Frame frame = frames.get(nowFrameIndex);
        if (!frame.checkThrowingPossible()) {
            nowFrameIndex++;
        }
    }

    public User getUser() {
        return this.user;
    }
}
