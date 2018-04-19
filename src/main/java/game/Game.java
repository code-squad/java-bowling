package game;

import frame.Frame;
import frame.FrameManager;
import input.Input;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Frame> frames = new ArrayList<>();

    public void match() {
        for (int i = 1; i < 10; i++) {
            running(i);

        }
    }

    public List<Frame> running(int i) {
        FrameManager manager = new FrameManager();
        Input input = new Input();
        Frame frame = manager.onFrame(input.inputNum(i));
        if (frame.finishFrame()) {
            frames.add(frame);
            ResultView.upperBar(getFrames(), "kjy");
            return frames;
        }
        frame = manager.onFrame(input.inputNum(i));
        frames.add(frame);
        ResultView.upperBar(getFrames(), "kjy");
        return frames;
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
