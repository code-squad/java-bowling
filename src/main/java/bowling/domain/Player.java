package bowling.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final String name;
    private final List<Frame> frames;

    public Player(String name) {
        this.name = name;
        List<Frame> frames = new ArrayList<>();
        for (int frameCount = 0; frameCount < 8; frameCount++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        this.frames = frames;
    }
}
