package domain.score;

import java.util.Optional;

public class Strike extends State {

    Strike() {
        pin = Pin.TEN;
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
    public PinType getType() {
        return PinType.STRIKE;
    }

    @Override
    public String toString() {
        return "X";
    }
}
