package domain;

import java.util.List;
import java.util.Objects;

public class Round {

    private RoundFrames roundFrames;

    private Round() {
        roundFrames = RoundFrames.of();
    }

    public static Round of() {
        return new Round();
    }

    public void trying(int score) {
        roundFrames.lastFrameTry(score);
        if (roundFrames.lastFrameWasEnd()) {
            roundFrames.addNextFrame();
        }
    }

    public List<Frame> getRoundFrames() {
        return roundFrames.getRoundFrames();
    }

    public boolean isRoundEnd() {
        return roundFrames.isTenthFrameAndEnd();
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

    public int getFrameNumber() {
        return roundFrames.getFrameNumber();
    }
}
