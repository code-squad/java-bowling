package bowling.domain;

import bowling.domain.state.Ready;
import bowling.domain.state.State;

public class Frame {
    private final int id;
    private State state;

    Frame() {
        this(1);
    }

    Frame(int id) {
        this.id = id;
        state = new Ready();
    }

    public void roll(int knockDownPins) {
        Pins pins = new Pins();
        pins.knockDown(knockDownPins);

        state = state.roll(pins);
    }

    public int getScore() {
        return state.getKnockDownsPins();
    }

    public boolean canRoll() {
        return state.canRoll();
    }

    public int getFrameId() {
        return id;
    }

    public String getScoreSymbol() {
        return state.getScore();
    }

    boolean isKnockDownAllFrame() {
        return state.isStrike() || state.isSpare();
    }
}
