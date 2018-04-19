package frame;

public class FrameManager {
    private Frame frame = new Frame();

    public Frame onFrame(int i) {
        frame.shoot(i);
        if (frame.finishFrame()) {
            System.out.println("frame status is " + frame.checkStatus().toString());
            return frame;
        }
        return frame;
    }
}
