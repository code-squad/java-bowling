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
//        assignCalculableStatus();
        transferStatusToOtherFrames();
        addFrame();
    }

    private void presentFrameTry(final int score) {
        presentFrame().trying(score);
        if (roundFrames.size() != 1) {
            if (roundFrames.get(roundFrames.size() - 2).isSpare()) {
                presentFrame().changeCalculateStatusToDo();
            }
        }
    }

    private void assignCalculableStatus() {
        if (isRoundEnd()) {
            presentFrame().changeCalculateStatusToDo();
            return;
        }
        if (roundFrames.size() != 1) {
            presentFrame().assignCalculableState(roundFrames.get(roundFrames.size() - 2));
        }
    }

    private void transferStatusToOtherFrames() {
        if (transferCondition()) {
            transferStatusToFrames();
        }
    }

    private void addFrame() {
        if (isPresentFrameEnd()) {
            addNextFrame();
        }
    }

    private boolean transferCondition() {
        return roundFrames.size() != 1 && presentFrame().isCalculationDo();
    }

    private void transferStatusToFrames() {
        roundFrames = transferStatusBackward(roundFrames);
//        roundFrames = transferStatusForward(roundFrames);
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

    private List<Frame> transferStatusBackward(List<Frame> roundFrames) {
        final int size = roundFrames.size();
        presentFrame().changeCalculationStatusToNotYet();
        for (int i = 1; i < size; i++) {
            this.roundFrames.get(size - (i + 1)).isGivenMessageFromPresentFrame123123(this.roundFrames.get(size - i));
        }
        return roundFrames;
    }

    private List<Frame> transferStatusForward(List<Frame> roundFrames) {
        final int size = roundFrames.size();
        for (int i = size; i > 1; i--) {
            this.roundFrames.get(size - i + 1).isGivenMessageFromBeforeFrame(this.roundFrames.get(size - i));
        }
        return roundFrames;
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
