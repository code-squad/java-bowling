package bowling.frame.state;

import bowling.frame.CannotCalculateException;

public abstract class Running implements State {
    @Override
    public boolean isFinish() {
        return false;
    }

    @Override
    public Score getScore() {
        throw new CannotCalculateException();
    }
}
