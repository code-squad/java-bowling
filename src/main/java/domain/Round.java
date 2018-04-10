package domain;

import com.sun.javafx.UnmodifiableArrayList;

import java.util.ArrayList;
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
        if (isPresentFrameEnd()) {
            addNextFrame();
        }
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

    public UnmodifiableArrayList<Frame> getRoundFrames() {
        return (UnmodifiableArrayList<Frame>) roundFrames;
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
