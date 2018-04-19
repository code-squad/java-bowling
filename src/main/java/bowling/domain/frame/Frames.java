package bowling.domain.frame;

import java.util.ArrayList;
import java.util.List;

public class Frames {
    private final List<Frame> frames;
    private ScoreCalculator calculator;

    public Frames() {
        List<Frame> frames = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            frames.add(new NormalFrame());
        }
        frames.add(new LastFrame());
        this.frames = frames;
    }

    public void calculateScores() {
        ScoreCalculator calculator = new ScoreCalculator();
    }
}
