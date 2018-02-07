package domain.frame;

import domain.score.Pin;
import domain.score.PinType;
import domain.score.Ready;
import domain.score.State;

import java.util.Optional;

public abstract class Frame {

    final int frameNo;

    Frame next;

    State state;

    Frame(Pin first, int frameNo) {
        this.state = Ready.getInstance().bowl(first);
        this.frameNo = frameNo;
    }

    public boolean isStrike() {
        return state.getType() == PinType.STRIKE;
    }

    public Integer getFirstScore() {
        return state.getScore();
    }

    public abstract boolean isFinish();

    public abstract Optional<Frame> bowl(Pin pin);

    public abstract Optional<Integer> getFrameScore();

    public abstract Optional<Integer> getSumOfFirstAndSecondScore();

    public abstract Optional<Integer> calculateScoreWithBefore(Frame before);

    public abstract Optional<Integer> calculateScoreWithBefore(Frame f1, Frame f2);

}
