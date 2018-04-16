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
        Frame currentFrame = getCurrentFrame();
        Frame resultFrame = currentFrame.roll(num);
        frames.forEach(frame -> frame.refreshPinNum(currentFrame));
        if (currentFrame.isDiff(resultFrame)) {
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

    public int getCurrentFrameNum() {
        Frame currentFrame = getCurrentFrame();
        return currentFrame.getFrameNum();
    }

    private Frame getCurrentFrame() {
        return frames.get(frames.size() - 1);
    }
}
