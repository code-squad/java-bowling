package game;

import input.Input;

public class Game {
    public void match() {
        for (int i = 1; i < 10; i++) {
            System.out.println(i + "번 프레임");
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
