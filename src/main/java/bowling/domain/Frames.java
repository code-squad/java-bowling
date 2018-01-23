package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private final static int MAX_FRAME_COUNT = 9;
    private List<Frame> frames;
    public Frames() {
        this.frames = new ArrayList<>();
        for (int i = 0; i < MAX_FRAME_COUNT; i++) {
            frames.add(new Frame(new Score()));
        }
    }

    @Override
    public String toString() {
        String temp = "";
        if (frames != null) {
            for (Frame frame : frames) {
                temp+=frame.toString();
            }
        }
        return temp;
    }
}
