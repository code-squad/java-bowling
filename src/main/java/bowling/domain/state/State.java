package bowling.domain.state;

import bowling.domain.MaximumRollExceededException;
import bowling.domain.Pins;

public interface State {
    State roll(Pins pins) throws MaximumRollExceededException;

    boolean canRoll();

    int getKnockDownsPins();

    String getScore();

    boolean isStrike();

    boolean isSpare();
}
