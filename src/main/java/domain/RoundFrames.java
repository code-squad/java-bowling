package domain;

import java.util.ArrayList;
import java.util.List;

public class RoundFrames {

    List<Frame> roundFrames;

    public RoundFrames() {
        roundFrames = new ArrayList<>();
        roundFrames.add(new Frame());
    }

    public void lastFrameTry(int i) {
        roundFrames.get(roundFrames.size()-1).trying(i);
    }

    public boolean lastFrameWasEnd() {
        return roundFrames.get(roundFrames.size()-1).isFrameEnd();
    }

    public void addNextFrame() {
        roundFrames.add(new Frame());
    }

    public List<Frame> getRoundFrames() {
        return roundFrames;
    }
}
