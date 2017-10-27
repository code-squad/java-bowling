package bowling.frame.state;

import bowling.frame.CannotCalculateException;
import bowling.frame.pin.Pins;

public class Ready extends Running {   
    @Override
    public State bowl(Pins falledPins) {
        if (falledPins.isStrike()) {
            return new Strike();
        }
        return new FirstBowl(falledPins);
    }

    public Score cacluateAdditionalScore(Score score) {
        throw new CannotCalculateException();
    }

    @Override
    public String getDesc() {
        return "";
    }
}
