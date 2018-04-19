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
        String name = Input.inputName();
        for (int i = 1; i < 10; i++) {
            running(i, name);

        }
    }

    public List<Frame> running(int i, String name) {
        FrameManager manager = new FrameManager();
        Input input = new Input();
        Frame frame = manager.onFrame(input.inputNum(i));
        if (frame.finishFrame()) {
            frames.add(frame);
            ResultView.upperBar(getFrames(), name);
            return frames;
        }
        frame = manager.onFrame(input.inputNum(i));
        frames.add(frame);
        ResultView.upperBar(getFrames(), name);
        return frames;
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
