package frame;

public class FrameManager {
    private Frame frame = new Frame();
    public boolean onFrame(int i) {
        frame.shoot(i);
        if (frame.finishFrame()) {
            System.out.println("frame status is " + frame.checkStatus().toString());
            return true;
        }
        return false;
    }

    public Frame onFrame2(int i) {
        frame.shoot(i);
        if (frame.finishFrame()) {
            System.out.println("frame status is " + frame.checkStatus().toString());
            return frame;
        }
        System.out.println("Not strike 다시 굴리세요");
        return frame;
    }
}
