package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private static final int FRAME_MAX_VALUE = 10;

    private List<Frame> frames;

    public Frames() {
        frames = new ArrayList<>(FRAME_MAX_VALUE);

        for(int i = 0 ; i < FRAME_MAX_VALUE ; ++i)
            frames.add(new Frame());
    }

    public String printFrames() {
        StringBuilder sb = new StringBuilder();

        frames.stream()
                .map(f -> f.printFrame() + "|")
                .forEach(sb::append);

        return sb.toString();
    }
}
