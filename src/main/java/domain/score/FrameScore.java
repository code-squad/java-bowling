package domain.score;

import java.util.Optional;

public abstract class FrameScore {

    State state;

    FrameScore(Pin first) {
        this.state = Ready.getInstance().bowl(first);
    }

    public boolean isStrike() {
        return state instanceof Finish;
    }

    public Integer getFirstScore() {
        return state.getFirstScore();
    }

    public abstract boolean isFinish();

    public abstract void bowl(Pin pin);

    public abstract Optional<Integer> getFrameScore();

    public abstract Optional<Integer> getSumOfFirstAndSecondScore();
}
