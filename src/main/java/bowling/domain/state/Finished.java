package bowling.domain.state;

import bowling.domain.Pin;

abstract class Finished implements State {

    @Override
    public boolean isBowlable(Pin pin) {
        return false;
    }

    @Override
    public boolean isFinished() {
        return true;
    }

    @Override
    public boolean anyBowled() {
        return true;
    }
}
