package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Round {

    private static final int MAX_FRAME = 10;
    private List<Frame> roundFrames;

    private Round() {
        roundFrames = new ArrayList<>(MAX_FRAME);
        roundFrames.add(NormalFrame.of());
    }

    public static Round of() {
        return new Round();
    }

    public void trying(final int score) {
        presentFrameTry(score);
        assignCalculableToFrame();
        if (isPresentFrameEnd()) {
            addNextFrame();
        }
    }

    private void assignCalculableToFrame() {
        if (roundFrames.size() == 1) {
            lastFrame().assignCalculableState();
            return;
        }
        lastFrame().assignCalculableState(roundFrames.get(roundFrames.size()-2));
    }

    private void presentFrameTry(final int score) {
        lastFrame().trying(score);
    }

    private boolean isPresentFrameEnd() {
        return lastFrame().isFrameEnd();
    }

    private void addNextFrame() {
        if (roundFrames.size() == MAX_FRAME - 1) {
            roundFrames.add(LastFrame.of());
            return;
        }
        if (roundFrames.size() != MAX_FRAME) {
            roundFrames.add(NormalFrame.of());
        }
    }

    public boolean isRoundEnd() {
        return roundFrames.size() == MAX_FRAME && isPresentFrameEnd();
    }

    public int getFrameNumber() {
        return roundFrames.size();
    }

    public List<Frame> getRoundFrames() {
        return Collections.unmodifiableList(roundFrames);
    }

    private Frame lastFrame() {
        return roundFrames.get(roundFrames.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return Objects.equals(roundFrames, round.roundFrames);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roundFrames);
    }

}
