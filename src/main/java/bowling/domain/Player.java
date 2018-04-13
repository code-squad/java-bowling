package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Frame> frames;

    public Player(String name) {
        this.name = name;
        this.frames = initializeFrames();
    }

    private static List<Frame> initializeFrames() {
        List<Frame> frames = new ArrayList<>();
        for (int frameCount = 0; frameCount < 8; frameCount++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        return frames;
    }
}