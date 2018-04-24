package domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private static final int FIRST = 1;
    private static final int MAX_FRAME = 10;

    private List<Frame> frames = new ArrayList<>();

    public Frame createFirstFrame() {
        return new NormalFrame(FIRST);
    }

    public boolean isEmpty() {
        return frames.isEmpty();
    }

    public int getFinishedFrame() {
        return frames.size();
    }

    public void add(Frame frame) {
        if (frames.size() > MAX_FRAME) {
            throw new RuntimeException("1경기당 최대 10프레임입니다.");
        }
        frames.add(frame);
    }

    public boolean equalsFrameCount(int frameCount) {
        return frames.size() == frameCount;
    }

    public String printFramesState(int index) {
        return frames.get(index).printState();
    }

    public int printFramesScore(int index, int beforeScore) {
        return frames.get(index).getScore(beforeScore);
    }
}