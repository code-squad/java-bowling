package game;

import frame.Frame;
import frame.FrameManager;
import input.Input;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames = new ArrayList<>();

    public void match() {
        for (int i = 1; i < 10; i++) {
            running();
        }
    }

    public boolean running() {
        FrameManager frameManager = new FrameManager();
        Input input = new Input();
        if (frameManager.onFrame(input.inputNum())) {
            return true;
        }
        return frameManager.onFrame(input.inputNum());
    }

    public List<Frame> matching(int i) {
        FrameManager manager = new FrameManager();
        Input input = new Input();
        Frame frame = manager.onFrame2(input.inputNum());
        if (frame.finishFrame()) {
            frames.add(frame);
            return frames;
        }
        frames.add(manager.onFrame2(input.inputNum()));
        return frames;
    }
}
