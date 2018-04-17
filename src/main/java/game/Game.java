package game;

import frame.FrameManager;
import input.Input;

public class Game {
    public void match() {
        for (int i = 1; i < 10; i++) {
            running(i);
        }
    }

    public boolean running(int i) {
        FrameManager frameManager = new FrameManager();
        Input input = new Input();
        if (frameManager.onFrame(input.inputNum(i))) {
            return true;
        }
        return frameManager.onFrame(input.inputNum(i));
    }
}
