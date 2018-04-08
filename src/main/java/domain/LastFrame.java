package domain;

import java.util.Objects;

public class LastFrame extends Frame{

    public LastFrame() {
        super();
    }

    public boolean isFrameEnd() {
        return scores.isTryThird() || (scores.isTrySecond() && !scores.isTen());
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
