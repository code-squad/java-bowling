package game;

import frame.Frames;
import input.Input;

public class Game {
    public void match() {
        for (int i = 1; i < 10; i++) {
            running(i);
        }
    }

    public boolean running(int i) {
        Frames frames = new Frames();
        Input input = new Input();
        if (frames.onFrame(input.inputNum(i))) {
            return true;
        }
        return frames.onFrame(input.inputNum(i));
    }
}
