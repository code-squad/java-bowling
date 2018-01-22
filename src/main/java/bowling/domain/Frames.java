package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private static final int FRAME_MAX_VALUE = 10;

    private List<Frame> frames;

    public Frames() {
        frames = new ArrayList<>(FRAME_MAX_VALUE);
        frames.add(new Frame());
    }
}
