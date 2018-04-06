package domain.frame;

public class FrameFactory {

    public static Frame of(int frameNum) {
        if (Frames.isLast(frameNum)) {
            return new LastFrame();
        }
        return new NormalFrame();
    }
}
