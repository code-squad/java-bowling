package frame;

public class FrameManager {
    private Frame frame = new Frame();

    public Frame onFrame(int i) {
        frame.shoot(i);
        if (frame.finishFrame()) {
            return frame;
        }
        return frame;
    }
}
