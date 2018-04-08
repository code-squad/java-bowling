package domain;

import java.util.Objects;

public class LastFrame extends Frame{

    Scores scores;

    @Override
    public boolean isFrameEnd() {
        return scores.isTryThird();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LastFrame lastFrame = (LastFrame) o;
        return Objects.equals(scores, lastFrame.scores);
    }

    @Override
    public int hashCode() {

        return Objects.hash(scores);
    }
}
