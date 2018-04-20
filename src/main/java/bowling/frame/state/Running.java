package bowling.frame.state;

import bowling.frame.CannotCalculateException;
import bowling.frame.pin.Score;

abstract class Running implements State {
    @Override
    public boolean isFinish() {
        return false;
    }

    @Override
    public Score getScore() {
        throw new CannotCalculateException();
    }
}
