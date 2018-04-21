package domain.frame;

import domain.frame.result.Board;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private List<Frame> frames = new ArrayList<>();

    public Frames() {
        frames.add(Frame.of(1));
    }

    public void roll(int num) throws IllegalArgumentException {
        checkFrameAdd(getCurrentFrame().roll(num));
    }

    private void checkFrameAdd(Frame resultFrame) {
        if (getCurrentFrame() != resultFrame) {
            frames.add(resultFrame);
        }
    }

    public boolean isFinish() {
        Frame currentFrame = getCurrentFrame();
        return currentFrame.isLast() && currentFrame.isFinish();
    }

    public Board getBoard() {
        Frame firstFrame = frames.get(0);
        return firstFrame.getBoard();
    }

    private Frame getCurrentFrame() {
        return frames.get(frames.size() - 1);
    }

    public boolean isFinishFrame(int frameNum) {
        int frameIdx = frameNum - 1;
        return frames.get(frameIdx).isFinish();
    }
}
