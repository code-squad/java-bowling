package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (roundFrames.size() == 9) {
            roundFrames.add(new LastFrame());
            return;
        }
        roundFrames.add(new Frame());
    }

    public List<Frame> getRoundFrames() {
        return roundFrames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundFrames that = (RoundFrames) o;
        return Objects.equals(roundFrames, that.roundFrames);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roundFrames);
    }
}
