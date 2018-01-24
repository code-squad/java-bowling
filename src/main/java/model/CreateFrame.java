package model;

import java.util.ArrayList;
import java.util.List;

public class CreateFrame {
    public static void create(List<Frame> frames) {
        if (getCurrentFrameNumber(frames) >= 9) {
            addFinalFrames(frames);
        }
        if (getCurrentFrameNumber(frames) < 9) {
            addNormalFrame(frames);
        }
    }

    private static void addNormalFrame(List<Frame> frames) {
        frames.add(new NormalFrame());
    }

    private static void addFinalFrames(List<Frame> frames) {
        frames.add(new FinalFrame());
    }

    private static Integer getCurrentFrameNumber(List<Frame> frames) {
        return frames.size();
    }

    public static List<Frame> initFrames(List<Frame> frames) {
        frames = new ArrayList();
        addNormalFrame(frames);
        return frames;
    }
}
