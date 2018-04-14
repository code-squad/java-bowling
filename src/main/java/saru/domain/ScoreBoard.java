package saru.domain;

import java.util.*;

public class ScoreBoard {
    private static final int MAX_DOWN_PIN = 10;
    private static final int MAX_NORMAL_FRAME = 9;
    private int nowFrameIndex = 0;

    private List<Frame> frames = new ArrayList<>(MAX_DOWN_PIN);

    private ScoreBoard() {
        init();
    }

    private void init() {
        for (int i = 0; i < MAX_NORMAL_FRAME; i++) {
            frames.add(NormalFrame.of());
        }

        frames.add(LastFrame.of());
    }

    public static ScoreBoard of() {
        return new ScoreBoard();
    }

    int getFrameSize() {
        return frames.size();
    }

    int throwing(DownPin downPin) {
        Frame normalFrame = frames.get(nowFrameIndex);
        normalFrame.throwing(downPin);

        return normalFrame.getDownPinsSize();
    }

    int getNowFrameIndex() {
        return nowFrameIndex;
    }

    Frame getNowFrame() {
        return frames.get(getNowFrameIndex());
    }

    void nextFrame() {
        Frame normalFrame = frames.get(nowFrameIndex);
        if (!normalFrame.checkThrowingPossible()) {
            nowFrameIndex++;
        }
    }
}
