package domain.frame;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    public static final int LIMIT = 10;
    private List<Frame> frames = new ArrayList<>();

    public boolean isContains(Frame frame) {
        return frames.contains(frame);
    }

    public static boolean isLimit(int frameNum) {
        return frameNum == LIMIT;
    }
}
