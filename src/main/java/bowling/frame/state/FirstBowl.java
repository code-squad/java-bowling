package bowling.frame.state;

import bowling.frame.CannotCalculateException;
import bowling.frame.pin.Pins;

class FirstBowl extends Running {
    private Pins firstPins;

    FirstBowl(Pins falledPins) {
        this.firstPins = falledPins;
    }

    @Override
    public State bowl(Pins falledPins) {
        if (firstPins.isSpare(falledPins)) {
            return new Spare(firstPins, falledPins);
        }

        return new Miss(firstPins, falledPins);
    }
    
    public Score cacluateAdditionalScore(Score score) {
        score = score.bowl(this.firstPins.getFalledPins());
        if (score.canCalucateScore()) {
            return score;
        }
        throw new CannotCalculateException();
    }

    @Override
    public String getDesc() {
        return this.firstPins.getFalledPins() + " | ";
    }
}
