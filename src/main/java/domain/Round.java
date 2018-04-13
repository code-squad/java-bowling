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
        if (roundFrames.size() != 1 && presentFrame().isDoCalculation()) {
            beforeFrame().giveMessageFrom(presentFrame());
        }
        if (isPresentFrameEnd()) {
            addNextFrame();
        }
    }

    public void recursionTestBackward(int i) {
        Frame presentFrame = roundFrames.get(roundFrames.size() - i);
        Frame beforeFrame = roundFrames.get(roundFrames.size() - (i+1));
        if (i != roundFrames.size() && roundFrames.size() != 1) {
            beforeFrame.giveMessageFrom(presentFrame);
            i++;
            recursionTestBackward(i);
        }
    }

    public void recursionTestForward(int i) {
        Frame presentFrame = roundFrames.get(roundFrames.size() - i);
        Frame beforeFrame = roundFrames.get(roundFrames.size() - (i+1));
        if (i != 1 && roundFrames.size() != 1) {
            presentFrame.giveMessageFromBefore(beforeFrame);
            i--;
            recursionTestForward(i);
        }
    }



    private void assignCalculableToFrame() {
        if (roundFrames.size() == 1) {
            presentFrame().assignCalculableState();
            return;
        }
        presentFrame().assignCalculableState(roundFrames.get(roundFrames.size()-2));
    }

    private void presentFrameTry(final int score) {
        presentFrame().trying(score);
    }

    private boolean isPresentFrameEnd() {
        return presentFrame().isFrameEnd();
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

    private Frame presentFrame() {
        return roundFrames.get(roundFrames.size() - 1);
    }

    private Frame beforeFrame() {
        return roundFrames.get(roundFrames.size() - 2);
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
