package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Round {

    private List<Frame> roundFrames;

    private Round() {
        roundFrames = new ArrayList<>(10);
        roundFrames.add(NormalFrame.of());
    }

    public static Round of() {
        return new Round();
    }

    public void trying(final int score) {
        presentFrameTry(score);
        System.out.println(score);
        assignCalculableToFrame();
        if (isPresentFrameEnd()) {
            addNextFrame();
        }
    }

    private void assignCalculableToFrame() {
        if (roundFrames.size() == 1) {
            System.out.println("아직까지 프레임은 한개");
            roundFrames.get(roundFrames.size() - 1).assignCalculableState();
            return;
        }
        roundFrames.get(roundFrames.size()-1).assignCalculableState(roundFrames.get(roundFrames.size()-2));
    }

    private void presentFrameTry(final int score) {
        roundFrames.get(roundFrames.size() - 1).trying(score);
    }

    private boolean isPresentFrameEnd() {
        return roundFrames.get(roundFrames.size() - 1).isFrameEnd();
    }

    private void addNextFrame() {
        if (roundFrames.size() == 9) {
            roundFrames.add(LastFrame.of());
            return;
        }
        if (roundFrames.size() != 10) {
            roundFrames.add(NormalFrame.of());
        }
    }

    public boolean isRoundEnd() {
        return roundFrames.size() == 10 && isPresentFrameEnd();
    }

    public int getFrameNumber() {
        return roundFrames.size();
    }

    public List<Frame> getRoundFrames() {
        return Collections.unmodifiableList(roundFrames);
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
