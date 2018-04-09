package utils;

import domain.frame.Frame;
import domain.frame.Frames;
import domain.frame.LastFrame;
import domain.frame.NormalFrame;

public class FrameFactory {

    public static Frame of(int frameNum) {
        if (Frames.isLast(frameNum)) {
            return new LastFrame();
        }
        return new NormalFrame();
    }
}
