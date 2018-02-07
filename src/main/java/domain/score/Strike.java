package domain.score;

import java.util.Optional;

public class Strike extends State {

    Strike() {
        pin = Pin.TEN;
        left = 2;
    }

    @Override
    public Optional<Integer> getTotalScore() {
        if (getNext().isPresent()) {
            return next.getNext()
                       .map(n -> n.getScore() + next.getScore() + 10);
        }
        return Optional.empty();
    }

    @Override
    public boolean isFinish() {
        return true;
    }

    @Override
    public State bowl(Pin pin) {
        if (!isLeft()) {
            throw new IllegalStateException();
        }
        left--;
        if (getNext().isPresent()) {
            return next.bowl(pin);
        }
        return next = Ready.getInstance().bowl(pin);
    }

    @Override
    public String toString() {
        return "X";
    }
}
