package domain;

import java.util.ArrayList;
import java.util.List;

public class Frames {

    List<Frame> frames = new ArrayList<>();

    int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    public void tryFrame(Frame frame) {
        frames.add(frame);
    }
}
