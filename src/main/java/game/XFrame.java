package game;

import java.util.ArrayList;

public class XFrame {
    private Frame frame;
    private ArrayList<Frame> frames = new ArrayList<>();

    public boolean onFrame(int i) {
        frame = new Frame();
        frame.shoot(i);
        frames.add(frame);
        if (frame.finishFrame())
            return true;

        frame.shoot(i);
        if (frame.finishFrame())
            return true;
        return false;
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }
}
