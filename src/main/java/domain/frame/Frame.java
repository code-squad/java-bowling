package domain.frame;

import domain.score.Pin;
import domain.score.Ready;
import domain.score.State;
import domain.score.Strike;

import java.util.Optional;

public abstract class Frame {

    State state;

    Frame(Pin first) {
        this.state = Ready.getInstance().bowl(first);
    }

    public boolean isStrike() {
        return state instanceof Strike;
    }

    public Integer getFirstScore() {
        return state.getFirstScore();
    }

    public abstract boolean isFinish();

    public abstract void bowl(Pin pin);

    public abstract Optional<Integer> getFrameScore();

    public abstract Optional<Integer> getSumOfFirstAndSecondScore();

    public abstract Optional<Integer> calculateScoreWithBefore(Frame before);

    public abstract Optional<Integer> calculateScoreWithBefore(Frame f1, Frame f2);

}
