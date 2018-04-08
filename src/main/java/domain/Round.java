package domain;

import java.util.List;

public class Round {

    RoundFrames roundFrames;

    public Round() {
        roundFrames = new RoundFrames();
    }

    public void trying(int i) {
        roundFrames.lastFrameTry(i); // last frame
        if (roundFrames.lastFrameWasEnd()) {
            roundFrames.addNextFrame();
        }
    }

    public List<Frame> getRoundFrames() {
        return roundFrames.getRoundFrames();
    }
}
