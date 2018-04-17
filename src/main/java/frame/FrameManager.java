package frame;

import java.util.ArrayList;
import java.util.List;

public class FrameManager {
    private Frame frame = new Frame();

    public boolean onFrame(int i) {
        List<Frame> frames = new ArrayList<>();
        frame.shoot(i);
        if (frame.finishFrame()) {
            System.out.println("frame status is " + frame.checkStatus().toString());
            frames.add(frame);
            return true;
        }
        return false;
    }
}
