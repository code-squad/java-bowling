package domain.score;

import java.util.Optional;

public class Strike extends State {

    Strike() {
        super(Pin.TEN, 2);
    }

    @Override
    public Optional<Integer> getTotalScore() {
        if (hasNext()) {
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
        reduceLeft();
        if (hasNext()) {
            return next.bowl(pin);
        }
        return next = Ready.bowl(pin);
    }

    @Override
    public String toString() {
        return "X";
    }
}
