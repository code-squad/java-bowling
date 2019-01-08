package bowling.domain.state;

abstract class Running implements State {

    @Override
    public boolean isFinished() {
        return false;
    }
}
