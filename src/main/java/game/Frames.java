package game;

import java.util.ArrayList;

public class Frames {
    private ArrayList<Frame> frames = new ArrayList<>();
    private int noFrame = 1;
    Frame frame = new Frame();

    public boolean onFrame(int i) {
        frame.shoot(i);
        frames.add(frame);
        if (frame.finishFrame()) {
            noFrame++;
            return true;
        }
        return false;
    }

    public int getNoFrame() {
        return noFrame;
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }
}
