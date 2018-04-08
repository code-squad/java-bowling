package domain;

import java.util.ArrayList;
import java.util.List;

public class Round {

    List<Frame> roundFrames;

    public Round() {
        roundFrames = new ArrayList<>();
        roundFrames.add(new Frame());
    }

    public void trying(int i) {
        roundFrames.get(roundFrames.size() - 1).trying(i); // last frame
        if (roundFrames.get(roundFrames.size() - 1).isFrameEnd()) {
            roundFrames.add(new Frame());
        }
    }

    public List<Frame> getRoundFrames() {
        return roundFrames;
    }
}
